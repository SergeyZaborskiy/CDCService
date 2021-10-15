package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlAirportService

@RestController
@RequestMapping("api/v1/converter/airports")
class AirportConverter (private val msService: MsSqlAirportService) {

    @GetMapping("{airport_id}")
    fun msSqltoPostgreById (@PathVariable airport_id: Int) : Airport {
        return Airport(msService.getById(airport_id))
    }
}