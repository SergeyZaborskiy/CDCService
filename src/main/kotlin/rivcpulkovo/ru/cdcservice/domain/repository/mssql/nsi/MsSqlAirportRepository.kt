package rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirport

@Repository
interface MsSqlAirportRepository : JpaRepository<MsSqlAirport, Int> {
}