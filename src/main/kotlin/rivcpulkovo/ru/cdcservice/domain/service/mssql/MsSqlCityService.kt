package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.MsSqlCityRepository


@Service
@Transactional("nsiTransactionManager")
class MsSqlCityService(private val repository: MsSqlCityRepository) {


}