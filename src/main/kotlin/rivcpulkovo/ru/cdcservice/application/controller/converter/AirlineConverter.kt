package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirlines
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airline
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlAirlineService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.AirlinePostgreService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService

@RestController
@RequestMapping("api/v1/converter/airlines")
class AirlineConverter(
    private val msAirlineService: MsSqlAirlineService,
    private val pgAirlineService: AirlinePostgreService,
    private val pgCountryService: CountryService
) {

    final val LOGGER: Logger = LoggerFactory.getLogger(AirlineConverter::class.java)

    @GetMapping("{airline_id}")
    fun msSqlToPostgreById(@PathVariable airline_id: Int): Airline {
        val msAirline = msAirlineService.getById(airline_id)
        LOGGER.info("Airline id is ${msAirline.id}")
        val country = pgCountryService.getByAlpha2(msAirline.cc)
        val airline = Airline(msAirline)
        airline.country = country
        return airline
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        val msAirlines: List<MsSqlAirlines> = msAirlineService.getAll()

        for (msAirline in msAirlines) {
            LOGGER.info("Airline id is ${msAirline.id}")
            if (pgAirlineService.existsByInnerId(msAirline.id)) continue
            else {
                val country = pgCountryService.getByAlpha2(msAirline.cc)
                val airline = Airline(msAirline)
                airline.country = country
                pgAirlineService.saveOrUpdate(airline)
            }
        }

        return "Done"
    }
}