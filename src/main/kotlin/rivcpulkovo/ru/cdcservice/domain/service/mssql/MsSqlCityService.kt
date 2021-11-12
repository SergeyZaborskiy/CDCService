package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlCity
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi.MsSqlCityRepository


@Service
class MsSqlCityService(private val repository: MsSqlCityRepository) {

    fun getAll(): List<MsSqlCity> {
        return repository.findAll()
    }

    fun getById(id: Int): MsSqlCity {
        return repository.getById(id)
    }
}