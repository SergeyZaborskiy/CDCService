package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Country
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlCountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.LanguageService

@RestController
@RequestMapping("api/v1/converter/countries")
class CountryConverter(
    private val msService: MsSqlCountryService,
    private val pgCountryService: CountryService,
    private val pgLanguageService: LanguageService
) {

    @GetMapping("{country_id}")
    fun msSqlToPostgreById(@PathVariable country_id: String): Country {
        val msCountry = msService.getById(country_id)
        val pgCountry = Country(msCountry)
        val language = pgLanguageService.getById(2)
        pgCountry.defaultLang = language
        return pgCountry
    }

    @GetMapping("{airport_id}/save")
    fun msSqlSaveToPostgreById(@PathVariable airport_id: String): String {
        val msCountry = msService.getById(airport_id)
        val pgCountry = Country(msCountry)
        val language = pgLanguageService.getById(2)
        pgCountry.defaultLang = language
        pgCountryService.saveOrUpdate(pgCountry)
        return "Done"
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        val msCountries = msService.getAll()
        for (msCountry in msCountries) {
            if (pgCountryService.existsByAlpha2(msCountry.id!!)) {
                continue
            } else {
                val pgCountry = Country(msCountry)
                val language = pgLanguageService.getById(2)
                pgCountry.defaultLang = language
                pgCountryService.saveOrUpdate(pgCountry)
            }
        }
        return "Done"
    }
}