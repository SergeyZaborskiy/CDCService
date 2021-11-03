package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Country
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService


@RestController
@RequestMapping("api/v1/pg/countries")
class CountryController(private val pgCountryService: CountryService) {
    @GetMapping
    fun getAll(): List<Country> {
        return pgCountryService.getAll()
    }

    @GetMapping("{countryId}")
    fun getById(@PathVariable countryId: Int): Country {
        return pgCountryService.getById(countryId)
    }
}