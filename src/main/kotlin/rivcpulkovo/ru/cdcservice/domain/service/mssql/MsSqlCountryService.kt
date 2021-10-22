package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCountry
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.MsSqlCountryRepository

@Service
@Transactional("nsiTransactionManager")
class MsSqlCountryService(private val repository: MsSqlCountryRepository) {
    fun getAll(): List<MsSqlCountry> {
        return repository.findAll()
    }

    fun getById(id: String): MsSqlCountry {
        return repository.getById(id)
    }
}