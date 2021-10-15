package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.MsSqlCountryRepository

@Service
@Transactional("nsiTransactionManager")
class MsSqlCountryService(private val repository: MsSqlCountryRepository) {


}