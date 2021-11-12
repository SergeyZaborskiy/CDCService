package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.AircraftType
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlAircraftTypeService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.AircraftTypePostgreService

@RestController
@RequestMapping("api/v1/converter/aircraftTypes")
class AircraftTypeConverter(
    private val msAircraftTypeService: MsSqlAircraftTypeService,
    private val pgAircraftTypeService: AircraftTypePostgreService
) {

    final val LOGGER: Logger = LoggerFactory.getLogger(AircraftTypeConverter::class.java)

    @GetMapping("/{ts}/{ms}")
    fun msSqlToPostgreByTsAndMd(@PathVariable ms: String, @PathVariable ts: String): AircraftType {
        var msAircraftType = if (ms.isNullOrBlank()) {
            msAircraftTypeService.getById(ts)
        } else {
            msAircraftTypeService.getByTsAndMd(ts, ms)
        }

        return AircraftType(msAircraftType)
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        val msAircraftTypes = msAircraftTypeService.getAll()
        for (msAircraftType in msAircraftTypes) {
            LOGGER.info("msAircraftType ts is ${msAircraftType.ts} and md is ${msAircraftType.md}")
            if (pgAircraftTypeService.existsByNativeAndMd(msAircraftType.ts, msAircraftType.md)) continue
            else {
                pgAircraftTypeService.saveOrUpdate(AircraftType(msAircraftType))
            }
        }
        return "Done"
    }
}