package rivcpulkovo.ru.cdcservice.domain.repository.mssql.rds;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.rds.MsSqlFlightPeriodsEntity

@Repository
@Transactional("rdsMsTransactionManager")
interface MsSqlFlightPeriodsEntityRepository : JpaRepository<MsSqlFlightPeriodsEntity, Int> {

    fun findTop3000ByOrderByBeginPeriodDesc(): List<MsSqlFlightPeriodsEntity>

}