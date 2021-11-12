package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirport
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlAirportService

@RestController
@RequestMapping("api/v1/mssql/airports")
class NSIPortNController(private val service: MsSqlAirportService) {


    @GetMapping
    fun getAll(): List<MsSqlAirport> {
        return service.getAll()
    }

    @GetMapping("{airport_id}")
    fun getById(@PathVariable airport_id: Int): MsSqlAirport {
        return service.getById(airport_id)
    }
}