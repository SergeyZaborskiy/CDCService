package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlAirportService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.AirportsPostgreService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CityService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.TimeZoneNameService

@RestController
@RequestMapping("api/v1/converter/airports")
class AirportConverter(
    private val msAirportService: MsSqlAirportService,
    private val pgAirportService: AirportsPostgreService,
    private val pgTimeZoneNameService: TimeZoneNameService,
    private val pgCountryService: CountryService,
    private val pgCityService: CityService
) {

    final val LOGGER: Logger = LoggerFactory.getLogger(AirportConverter::class.java)

    @GetMapping("{airport_id}")
    fun msSqlToPostgreById(@PathVariable airport_id: Int): Airport {

        val msAirport = msAirportService.getById(airport_id)
        LOGGER.warn("msAirport id is ${msAirport.id}")

        val countryCode = msAirport.cc?.id!!

        var airportTimeZone = msAirport.tz!!
        if (airportTimeZone.isNullOrBlank()) airportTimeZone = "  "

        LOGGER.warn("TimeZoneName was search by $countryCode and $airportTimeZone")
        val timeZoneName = pgTimeZoneNameService.getByNameAndCode(countryCode, airportTimeZone)

        val country = pgCountryService.getByAlpha2(countryCode)

        val city = pgCityService.getByInnerId(msAirport.idCity?.id!!)

        var airport = Airport(msAirport)
        airport.country = country
        airport.timeZoneName = timeZoneName
        airport.city = city

        return airport
    }

    @GetMapping("{airport_id}/save")
    fun msSqlSaveToPostgreById(@PathVariable airport_id: Int): String {
        return "Done"
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        val msAirports = msAirportService.getAll()
        for (msAirport in msAirports) {
            if (pgAirportService.existsByInnerId(msAirport.id)) continue
            else {
                LOGGER.warn("msAirport.id is ${msAirport.id}")

                val countryCode = msAirport.cc?.id!!

                var airportTimeZone = msAirport.tz!!

                if ((countryCode == "GB") and (airportTimeZone == "06")) airportTimeZone = "  " //msAirport id is 1156
                else if ((countryCode == "NO") and (airportTimeZone == "02")) airportTimeZone = "  " //msAirport id is 1827
                else if ((countryCode == "BE") and (airportTimeZone == "02")) airportTimeZone = "  " //msAirport id is 1853
                else if ((countryCode == "PF") and (airportTimeZone.isNullOrBlank())) airportTimeZone = "01" //msAirport id is 1856
                else if ((countryCode == "AU") and (airportTimeZone.isNullOrBlank())) airportTimeZone = "01" //msAirport id is 1859
                else if ((countryCode == "CA") and (airportTimeZone.isNullOrBlank())) airportTimeZone = "01" //msAirport id is 1864
                else if ((countryCode == "RU") and (airportTimeZone.isNullOrBlank())) airportTimeZone = "02" //msAirport id is 1870
                else if ((countryCode == "ID") and (airportTimeZone.isNullOrBlank())) airportTimeZone = "01" //msAirport id is 1872
                else if ((countryCode == "BR") and (airportTimeZone.isNullOrBlank())) airportTimeZone = "01" //msAirport id is 1902
                else if ((countryCode == "US") and (airportTimeZone.isNullOrBlank())) airportTimeZone = "01" //msAirport id is 1917
                else if (airportTimeZone.isNullOrBlank()) airportTimeZone = "  "


                LOGGER.warn("TimeZoneName was search by $countryCode and $airportTimeZone")

                val timeZoneName = pgTimeZoneNameService.getByNameAndCode(countryCode, airportTimeZone)

                val country = pgCountryService.getByAlpha2(countryCode)

                val city = pgCityService.getByInnerId(msAirport.idCity?.id!!)

                var airport = Airport(msAirport)
                airport.country = country
                airport.timeZoneName = timeZoneName
                airport.city = city

                pgAirportService.saveOrUpdate(airport)
            }
        }
        return "Done"
    }
}