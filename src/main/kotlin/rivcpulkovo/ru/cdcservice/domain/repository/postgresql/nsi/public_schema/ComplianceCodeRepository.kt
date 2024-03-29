package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.ComplianceCode

@Repository
interface ComplianceCodeRepository : JpaRepository<ComplianceCode, Int> {

    fun getByCodeEn(codeEn: String): ComplianceCode
}