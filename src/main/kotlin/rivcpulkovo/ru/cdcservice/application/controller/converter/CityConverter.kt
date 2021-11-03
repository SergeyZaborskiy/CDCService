package rivcpulkovo.ru.cdcservice.application.controller.converter


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.City
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZoneName
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlCityOldService
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlCityService
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlCountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CityService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.CountryService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.TimeZoneNameService

@RestController
@RequestMapping("api/v1/converter/cities")
class CityConverter(
    private val msCityService: MsSqlCityService,
    private val msSqlCityOldService: MsSqlCityOldService,
    private val msCountryService: MsSqlCountryService,
    private val pgCityService: CityService,
    private val pgCountryService: CountryService,
    private val pgTimeZoneNameService: TimeZoneNameService
) {

    final val LOGGER: Logger = LoggerFactory.getLogger(CityConverter::class.java)

    @GetMapping("{id}")
    fun msSqlToPostgreById(@PathVariable id: Int): City {
        val msCity = msCityService.getById(id)

        val country = pgCountryService.getByAlpha2(msCity.cc!!)

        val countryId = country.id
        LOGGER.info("country id is $countryId")

        var code = msCity.tz
        if (code.isNullOrBlank()) code = "  "
        LOGGER.info("time zone code is $code")

        val timeZoneExist =  pgTimeZoneNameService.existsByCountryIdAndCode(countryId, code)

        LOGGER.info("timeZoneExist zone code is $timeZoneExist")

        var timeZoneName: TimeZoneName? = null

        timeZoneName = if(timeZoneExist) {
            pgTimeZoneNameService.getByCountryIdAndCode(countryId, code)
        } else {
            pgTimeZoneNameService.getByCountryIdAndCode(countryId, "01")
        }

        val timeZoneNameId = timeZoneName.id
        LOGGER.info("timeZoneNameId is $timeZoneNameId")

        val oldCityApC = msSqlCityOldService.getById(msCity.apC?: "052").id
        LOGGER.info("oldCityApC id is $oldCityApC")

        val isCapital = msCountryService.existsByApC(oldCityApC)
        LOGGER.info("isCapital id is $isCapital")

        val city = City(msCity, countryId, timeZoneNameId, isCapital)
        LOGGER.info("countryId id is $countryId and  timeZoneNameId is $timeZoneNameId and isCapital is $isCapital")

        city.country = country
        city.timeZoneName = timeZoneName

        return city
    }

    @GetMapping("{id}/save")
    fun msSqlSaveToPostgreById(@PathVariable id: Int): City {
        val msCity = msCityService.getById(id)

        val country = pgCountryService.getByAlpha2(msCity.cc!!)

        val countryId = country.id
        LOGGER.info("country id is $countryId")

        var code = msCity.tz
        if (code.isNullOrBlank()) code = "  "
        LOGGER.info("time zone code is $code")

        val timeZoneExist =  pgTimeZoneNameService.existsByCountryIdAndCode(countryId, code)

        LOGGER.info("timeZoneExist zone code is $timeZoneExist")

        var timeZoneName: TimeZoneName? = null

        timeZoneName = if(timeZoneExist) {
            pgTimeZoneNameService.getByCountryIdAndCode(countryId, code)
        } else {
            pgTimeZoneNameService.getByCountryIdAndCode(countryId, "01")
        }

        val timeZoneNameId = timeZoneName.id
        LOGGER.info("timeZoneNameId is $timeZoneNameId")

        val oldCityApC = msSqlCityOldService.getById(msCity.iata?: "052").id
        LOGGER.info("oldCityApC id is $oldCityApC")

        val isCapital = msCountryService.existsByApC(oldCityApC)
        LOGGER.info("isCapital id is $isCapital")

        val city = City(msCity, countryId, timeZoneNameId, isCapital)
        LOGGER.info("countryId id is $countryId and  timeZoneNameId is $timeZoneNameId and isCapital is $isCapital")

        city.country = country
        city.timeZoneName = timeZoneName

        pgCityService.saveOrUpdate(city)

        return city
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        val cities = msCityService.getAll()

        for (msCity in cities) {
            if (pgCityService.existByInnerId(msCity.id ?: 0)) continue
            else {
                LOGGER.info("City id is ${msCity.id}")

                val country = pgCountryService.getByAlpha2(msCity.cc!!)

                val countryId = country.id
                LOGGER.info("countryId zone code is $countryId")

                var code = msCity.tz
                LOGGER.info("msCity tz is $code")
                if ((countryId == 243) and (code == "11")) code = "  "
                else if ((countryId == 21) and (code == "02")) code = "  "
                else if ((countryId == 158) and (code == "01")) code = "  "
                else if ((countryId == 174) and (code.isNullOrBlank())) code = "01"
                else if ((countryId == 14) and (code.isNullOrBlank())) code = "01"
                else if ((countryId == 39) and (code.isNullOrBlank())) code = "01"
                else if ((countryId == 190) and (code.isNullOrBlank())) code = "01"
                else if ((countryId == 101) and (code.isNullOrBlank())) code = "01" //City id is 4457
                else if ((countryId == 32) and (code.isNullOrBlank())) code = "01" //City id is 4481
                else if ((countryId == 233) and (code.isNullOrBlank())) code = "01" //City id is 4494
                else if ((countryId == 233) and (code.isNullOrBlank())) code = "01" //City id is 4494
                else if (code.isNullOrBlank()) code = "  "
                LOGGER.info("time zone code is $code")

                val timeZoneExist =  pgTimeZoneNameService.existsByCountryIdAndCode(countryId, code)

                LOGGER.info("timeZoneExist zone code is $timeZoneExist")

                var timeZoneName: TimeZoneName? = null

                timeZoneName = if(timeZoneExist) {
                    pgTimeZoneNameService.getByCountryIdAndCode(countryId, code)
                } else {
                    pgTimeZoneNameService.getByCountryIdAndCode(countryId, "  ")
                }

                val timeZoneNameId = timeZoneName.id

                val oldCityApC = msSqlCityOldService.getById(msCity.apC?: "052").id

                val isCapital = msCountryService.existsByApC(oldCityApC)

                val city = City(msCity, countryId, timeZoneNameId, isCapital)
                LOGGER.info("countryId id is $countryId and  timeZoneNameId is $timeZoneNameId and isCapital is $isCapital")

                city.country = country
                city.timeZoneName = timeZoneName

                pgCityService.saveOrUpdate(city)
            }
        }
        return "Done"
    }
}