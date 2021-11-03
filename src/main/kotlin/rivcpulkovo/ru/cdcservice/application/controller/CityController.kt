package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.City
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CityService

@RestController
@RequestMapping("api/v1/pg/cities")
class CityController(private val pgCityService: CityService) {

    @GetMapping
    fun getAll(): List<City> {
        return pgCityService.getAll()
    }

    @GetMapping("{cityId}")
    fun  getById(@PathVariable cityId: Int): City {
        return pgCityService.getById(cityId)
    }

    @GetMapping("/byCountry/{countryId}")
    fun getByCountryId(@PathVariable countryId: Int): List<City> {
        if (pgCityService.existsByCountryId(countryId)) return pgCityService.getByCountryId(countryId)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}