package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlAirportService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.AirportsPostgreService

@RestController
@RequestMapping("api/v1/converter/airports")
class AirportConverter (private val msService: MsSqlAirportService, private val postgreService: AirportsPostgreService) {

    @GetMapping("{airport_id}")
    fun msSqlToPostgreById (@PathVariable airport_id: Int) : Airport {
        return Airport(msService.getById(airport_id))
    }

    @GetMapping("{airport_id}/save")
    fun msSqlSaveToPostgreById(@PathVariable airport_id: Int): String{
        return postgreService.saveFromMssqlById(msService.getById(airport_id))
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        return postgreService.saveAllFromMssql(msService.getAll())
    }
}