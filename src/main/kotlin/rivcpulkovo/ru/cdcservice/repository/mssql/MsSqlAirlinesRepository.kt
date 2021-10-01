package rivcpulkovo.ru.cdcservice.repository.mssql;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.entity.mssql.MsSqlAirlines

@Repository
interface MsSqlAirlinesRepository : JpaRepository<MsSqlAirlines, Long>, JpaSpecificationExecutor<MsSqlAirlines> {
}