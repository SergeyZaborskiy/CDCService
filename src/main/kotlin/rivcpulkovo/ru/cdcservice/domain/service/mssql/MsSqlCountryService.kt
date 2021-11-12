package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlCountry
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi.MsSqlCountryRepository

@Service
class MsSqlCountryService(private val repository: MsSqlCountryRepository) {
    fun getAll(): List<MsSqlCountry> {
        return repository.findAll()
    }

    fun getById(id: String): MsSqlCountry {
        return repository.getById(id)
    }

    fun existsByApC(apC: String): Boolean {
        return repository.existsByApC(apC)
    }
}