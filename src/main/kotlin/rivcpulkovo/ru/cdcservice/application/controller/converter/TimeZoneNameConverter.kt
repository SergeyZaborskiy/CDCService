package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZone
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZoneName
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.TimeZoneNameService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.TimezoneService

@RestController
@RequestMapping("api/v1/converter/timeZonesNames")
class TimeZoneNameConverter(
    private val pgTimeZoneService: TimezoneService,
    private val pgCountryService: CountryService,
    private val pgTimeZoneNameService: TimeZoneNameService
) {

    @GetMapping("{timeZoneNameId}")
    fun timeZoneToTimeZoneNameById(@PathVariable timeZoneNameId: Int): TimeZoneName {
        val timeZone = pgTimeZoneService.getById(timeZoneNameId)
        val country = pgCountryService.getById(timeZone.country?.id!!)
        return TimeZoneName(timeZone, country.id, country.alpha2)
    }

    @GetMapping("{timeZoneNameId}/save")
    fun saveTimeZoneNameByTimeZoneId(@PathVariable timeZoneNameId: Int): String {
        val timeZone = pgTimeZoneService.getById(timeZoneNameId)
        val country = pgCountryService.getById(timeZone.country?.id!!)
        return if (pgTimeZoneNameService.existsByCountryIdAndCode(timeZone.country?.id!!, timeZone.code)) "Already have one"
        else {
            pgTimeZoneNameService.saveOrUpdate(TimeZoneName(timeZone, country.id, country.alpha2))
            "Done"
        }
    }


    @GetMapping("/saveAll")
    fun saveAllFromPostgre(): String {
        val timeZones: List<TimeZone> = pgTimeZoneService.getAll()
        for (timeZone in timeZones) {

            val country = pgCountryService.getById(timeZone.country?.id!!)

            if (pgTimeZoneNameService.existsByCountryIdAndCode(timeZone.country?.id!!, timeZone.code)) continue
            else {
                pgTimeZoneNameService.saveOrUpdate(TimeZoneName(timeZone, country.id, country.alpha2))
            }
        }
        return "Done"
    }
}

