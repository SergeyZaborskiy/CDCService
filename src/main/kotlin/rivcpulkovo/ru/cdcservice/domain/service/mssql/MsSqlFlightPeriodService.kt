package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.rds.MsSqlFlightPeriodsEntity
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.ufd.public.FlightPeriod
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.rds.MsSqlFlightPeriodsEntityRepository


@Service
@Transactional("rdsMsTransactionManager")
class MsSqlFlightPeriodService(private val repository: MsSqlFlightPeriodsEntityRepository) {

    @Transactional("rdsMsTransactionManager")
    fun findTop3000ByOrderByBeginPeriodDesc(): List<MsSqlFlightPeriodsEntity> {
        return repository.findTop3000ByOrderByBeginPeriodDesc()
    }

    @Transactional("rdsMsTransactionManager")
    fun getById(id: Int): MsSqlFlightPeriodsEntity {
        return repository.getById(id)
    }

}