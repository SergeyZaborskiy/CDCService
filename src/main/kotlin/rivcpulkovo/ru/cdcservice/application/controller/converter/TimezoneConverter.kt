package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Country
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZone
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlTimezoneService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.TimezoneService

@RestController
@RequestMapping("api/v1/converter/timeZones")
class TimezoneConverter(
    private val msTimeZoneService: MsSqlTimezoneService,
    private val pgTimeZoneService: TimezoneService,
    private val pgCountryService: CountryService
) {
    @GetMapping("{timeZone_id}")
    fun msSqlToPostgreById(@PathVariable timeZone_id: Int): TimeZone {
        val msTimeZone = msTimeZoneService.getById(timeZone_id)
        val pgCountry = pgCountryService.getByAlpha2(msTimeZone.cc)
        val pgTimeZone = TimeZone(msTimeZone)
        pgTimeZone.country = pgCountry
        pgTimeZoneService.saveOrUpdate(pgTimeZone)
        return pgTimeZone
    }

    @GetMapping("{timeZone_id}/country")
    fun getPgCountryByMsTimeZoneId(@PathVariable timeZone_id: Int): Country {
        val msTimezone = msTimeZoneService.getById(timeZone_id)
        return pgCountryService.getByAlpha2(msTimezone.cc)
    }

    @GetMapping("{timeZone_id}/save")
    fun msSqlSaveToPostgreById(@PathVariable timeZone_id: Int): String {
        val msTimeZone = msTimeZoneService.getById(timeZone_id)
        val pgCountry = pgCountryService.getByAlpha2(msTimeZone.cc)
        val pgTimeZone = TimeZone(msTimeZone)
        pgTimeZone.country = pgCountry
        pgTimeZoneService.saveOrUpdate(pgTimeZone)
        return "Done"
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        val msTimezones = msTimeZoneService.getAll()
        for (msTimeZone in msTimezones) {
            if (pgTimeZoneService.existsByInnerId(msTimeZone.id)) {
                continue
            } else {
                val pgCountry = pgCountryService.getByAlpha2(msTimeZone.cc)
                val pgTimeZone = TimeZone(msTimeZone)
                pgTimeZone.country = pgCountry
                pgTimeZoneService.saveOrUpdate(pgTimeZone)
            }
        }
        return "Done"
    }
}