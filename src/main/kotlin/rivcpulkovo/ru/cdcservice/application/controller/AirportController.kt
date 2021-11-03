package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.AirportsPostgreService

@RestController
@RequestMapping("api/v1/pg/airports")
class AirportController(private val pgAirportService: AirportsPostgreService) {

    @GetMapping
    fun getAll(): List<Airport> {
        return pgAirportService.getAll()
    }

    @GetMapping("{airportId}")
    fun getById(@PathVariable airportId: Int): Airport {
        return  pgAirportService.getById(airportId)
    }

    @GetMapping("/byCity/{cityId}")
    fun getByCityId(@PathVariable cityId: Int): List<Airport> {
        return  pgAirportService.findByCityName(cityId)
    }


    @GetMapping("/byCountry/{countryId}")
    fun getByCountryId(@PathVariable countryId: Int): List<Airport> {
        return  pgAirportService.findByCountryName(countryId)
    }

}