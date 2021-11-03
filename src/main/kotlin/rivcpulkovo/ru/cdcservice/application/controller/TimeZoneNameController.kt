package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZoneName
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.TimeZoneNameService

@RestController
@RequestMapping("api/v1/pg/timezonenames")
class TimeZoneNameController(private val pgTimeZoneNameService: TimeZoneNameService) {

    @GetMapping
    fun getAll(): List<TimeZoneName> {
        return pgTimeZoneNameService.getAll()
    }

    @GetMapping("{timeZoneNameId}")
    fun getById(@PathVariable timeZoneNameId: Int): TimeZoneName {
        return pgTimeZoneNameService.getById(timeZoneNameId)
    }
}