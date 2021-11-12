package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.ufd.public.FlightPeriod
import rivcpulkovo.ru.cdcservice.domain.service.postgre.ufd.FlightPeriodPostgreService

@RestController
@RequestMapping("api/v1/pg/flightPeriods")
class FlightPeriodController(private val pgFlightPeriodService: FlightPeriodPostgreService) {

    @GetMapping
    fun getAll(): List<FlightPeriod> {
        return pgFlightPeriodService.getAll()
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Int): FlightPeriod {
        return pgFlightPeriodService.getById(id)
    }
}