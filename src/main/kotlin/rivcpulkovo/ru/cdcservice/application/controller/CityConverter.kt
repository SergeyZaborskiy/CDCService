package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.City
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlCityService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CityService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService

@RestController
@RequestMapping("api/v1/converter/cities")
class CityConverter(
    private val msCityService: MsSqlCityService,
    private val msCityOldService: MsSqlCityService,
    private val pgCityService: CityService,
    private val pgCountryService: CountryService
) {

    @GetMapping("{id}")
    fun msSqlToPostgreById(@PathVariable id: Int): City {
        val msCity = msCityService.getById(id)
        val countryId = pgCountryService.getByAlpha2(msCity.cc!!).id
        val timeZoneInnerId = msCity.tz
        return City(msCity, countryId, 1, false)
    }

    @GetMapping("{id}/save")
    fun msSqlSaveToPostgreById(@PathVariable id: Int): String {
        return pgCityService.saveFromMssqlById(msCityService.getById(id))
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        return pgCityService.saveAllFromMssql(msCityService.getAll())
    }
}