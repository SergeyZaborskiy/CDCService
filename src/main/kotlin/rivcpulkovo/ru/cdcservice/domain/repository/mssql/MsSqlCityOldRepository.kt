package rivcpulkovo.ru.cdcservice.domain.repository.mssql;

import org.springframework.data.jpa.repository.JpaRepository
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCityOld

interface MsSqlCityOldRepository : JpaRepository<MsSqlCityOld, String> {
}