package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.ufd.public.FlightPeriod
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlComplianceCodeService
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlFlightPeriodService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.*
import rivcpulkovo.ru.cdcservice.domain.service.postgre.ufd.FlightPeriodPostgreService

@RestController
@RequestMapping("api/v1/converter/flightPeriods")
class FlightPeriodConverter(
    private val msFlightPeriodService: MsSqlFlightPeriodService,
    private val pgAirportService: AirportsPostgreService,
    private val pgAircraftTypeService: AircraftTypePostgreService,
    private val pgComplianceCodeService: ComplianceCodeService,
    private val pgAirlineService: AirlinePostgreService,
    private val msComplianceCodeService: MsSqlComplianceCodeService,
    private val pgFlightPeriod: FlightPeriodPostgreService,
) {

    final val LOGGER: Logger = LoggerFactory.getLogger(AircraftTypeConverter::class.java)

    @GetMapping("{id}")
    @Transactional("rdsMsTransactionManager")
    fun msSqlToPostgreById(@PathVariable id: Int): FlightPeriod {
        val msFlightPeriod = msFlightPeriodService.getById(id)

        val complianceCodeEn = msComplianceCodeService.getById(msFlightPeriod.IDTypeFlight).en

        val aircraftType = pgAircraftTypeService.findByNative(msFlightPeriod.aircraftType).id

        val airline = 1743

        val airportDeparture = pgAirportService.findByInnerId(msFlightPeriod.IDAirportDep).id
        val airportArrival = pgAirportService.findByInnerId(msFlightPeriod.IDAirportArr).id

        val complianceCode = pgComplianceCodeService.getByCodeEn(complianceCodeEn!!).id

        return FlightPeriod(msFlightPeriod, airportDeparture, airportArrival, aircraftType, complianceCode, airline)
    }


    @GetMapping("/saveAll")
    @Transactional("rdsMsTransactionManager")
    fun saveTop3000FromMssql(): String {
        val msFlightsPeriods = msFlightPeriodService.findTop3000ByOrderByBeginPeriodDesc()

        for (msFlightPeriod in msFlightsPeriods) {
            try {
                LOGGER.info("FP ID is ${msFlightPeriod.id}")

                val complianceCodeEn = msComplianceCodeService.getById(msFlightPeriod.IDTypeFlight).en

                val aircraftType = pgAircraftTypeService.findByNative(msFlightPeriod.aircraftType).id

                val airline = 1743

                val airportDeparture = pgAirportService.findByInnerId(msFlightPeriod.IDAirportDep).id
                val airportArrival = pgAirportService.findByInnerId(msFlightPeriod.IDAirportArr).id

                val complianceCode = pgComplianceCodeService.getByCodeEn(complianceCodeEn!!).id

                pgFlightPeriod.saveOrUpdate(FlightPeriod(msFlightPeriod, airportDeparture, airportArrival, aircraftType, complianceCode, airline))
            } catch (e: EmptyResultDataAccessException) {
                LOGGER.warn("Error in FP with ID:  ${msFlightPeriod.id}")
                continue
            }
        }
        return  "Done"
    }
}