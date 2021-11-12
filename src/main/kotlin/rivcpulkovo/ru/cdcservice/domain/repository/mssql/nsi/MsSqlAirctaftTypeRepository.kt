package rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirctaftType

@Repository
interface MsSqlAirctaftTypeRepository : JpaRepository<MsSqlAirctaftType, String> {

    fun getByTsAndMd (ts: String, md: String): MsSqlAirctaftType

    fun getByTs(ts: String): MsSqlAirctaftType
}