package rivcpulkovo.ru.cdcservice.domain.repository.mssql;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCity

@Repository
interface MsSqlCityRepository : JpaRepository<MsSqlCity, Int> {
}