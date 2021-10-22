package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Country
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlCountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService

@RestController
@RequestMapping("api/v1/converter/countries")
class CountryConverter(private val msService: MsSqlCountryService, private val pgService: CountryService) {

    @GetMapping("{country_id}")
    fun msSqlToPostgreById (@PathVariable country_id: String) : Country {
        return Country(msService.getById(country_id))
    }

    @GetMapping("{airport_id}/save")
    fun msSqlSaveToPostgreById(@PathVariable airport_id: String): String{
        return pgService.saveFromMssqlById(msService.getById(airport_id))
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        return pgService.saveAllFromMssql(msService.getAll())
    }
}