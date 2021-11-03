package rivcpulkovo.ru.cdcservice.application.controller.converter

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.ComplianceCode
import rivcpulkovo.ru.cdcservice.domain.service.mssql.MsSqlComplianceCodeService
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.ComplianceCodeService

@RestController
@RequestMapping("api/v1/converter/complianceCodes")
class ComplianceCodeConverter(private val msService:MsSqlComplianceCodeService, private val postgreService: ComplianceCodeService) {

    @GetMapping("{id}")
    fun msSqlToPostgreById (@PathVariable id: Int) : ComplianceCode {
        return ComplianceCode(msService.getById(id))
    }

    @GetMapping("{id}/save")
    fun msSqlSaveToPostgreById(@PathVariable id: Int): String{
        return postgreService.saveFromMssqlById(msService.getById(id))
    }

    @GetMapping("/saveAll")
    fun saveAllFromMssql(): String {
        return postgreService.saveAllFromMssql(msService.getAll())
    }
}