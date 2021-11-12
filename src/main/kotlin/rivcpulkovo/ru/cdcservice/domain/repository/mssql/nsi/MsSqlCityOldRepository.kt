package rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi;

import org.springframework.data.jpa.repository.JpaRepository
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlCityOld

interface MsSqlCityOldRepository : JpaRepository<MsSqlCityOld, String> {
}