package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlComplianceCodesTraffic
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.ComplianceCode
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.ComplianceCodeRepository

@Service
class ComplianceCodeService(private val repository: ComplianceCodeRepository) {

    fun getAll(): List<ComplianceCode> {
        return repository.findAll()
    }

    fun getById(id: Int): ComplianceCode {
        return repository.getById(id)
    }

    fun getByCodeEn(codeEn: String): ComplianceCode {
        return repository.getByCodeEn(codeEn)
    }

    fun saveOrUpdate(data: ComplianceCode) {
        repository.save(data)
    }

    fun saveFromMssqlById(complianceCode: MsSqlComplianceCodesTraffic): String {
        return if (repository.existsById(complianceCode.id)) {
            "Already have one"
        } else {
            val temp: ComplianceCode = ComplianceCode(complianceCode)
            repository.save(temp)
            "Save done"
        }
    }

    fun saveAllFromMssql(complianceCodes: List<MsSqlComplianceCodesTraffic>): String {
        for (complianceCode in complianceCodes) {
            if (repository.existsById(complianceCode.id)) {
                continue
            } else {
                val temp: ComplianceCode = ComplianceCode(complianceCode)
                repository.save(temp)
            }
        }
        return "Done"
    }

}