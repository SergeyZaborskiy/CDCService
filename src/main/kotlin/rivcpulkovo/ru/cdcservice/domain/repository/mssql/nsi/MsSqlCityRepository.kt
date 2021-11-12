package rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlCity

@Repository
interface MsSqlCityRepository : JpaRepository<MsSqlCity, Int> {
}