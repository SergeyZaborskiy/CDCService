package rivcpulkovo.ru.cdcservice.repository.mssql;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.entity.mssql.MsSqlAirctaftType
import rivcpulkovo.ru.cdcservice.entity.mssql.MsSqlAirctaftTypeId

@Repository
interface MsSqlAirctaftTypeRepository : JpaRepository<MsSqlAirctaftType, MsSqlAirctaftTypeId> {
}