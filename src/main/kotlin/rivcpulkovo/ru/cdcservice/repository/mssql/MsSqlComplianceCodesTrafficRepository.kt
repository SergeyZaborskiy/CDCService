package rivcpulkovo.ru.cdcservice.repository.mssql;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.entity.mssql.MsSqlComplianceCodesTraffic

@Repository
interface MsSqlComplianceCodesTrafficRepository : JpaRepository<MsSqlComplianceCodesTraffic, Int> {
}