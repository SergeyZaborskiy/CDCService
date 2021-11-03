package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZone
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.TimezoneService

@RestController
@RequestMapping("api/v1/pg/timezones")
class TimeZoneController(private val pgTimeZoneService: TimezoneService) {

    @GetMapping
    fun getAll(): List<TimeZone> {
        return pgTimeZoneService.getAll()
    }

    @GetMapping("{timeZoneId}")
    fun getById(@PathVariable timeZoneId: Int): TimeZone {
        return pgTimeZoneService.getById(timeZoneId)
    }
}