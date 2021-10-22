package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCityOld
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.MsSqlCityOldRepository

@Service
class MsSqlCityOldService(private val repository: MsSqlCityOldRepository) {

    fun getAll(): List<MsSqlCityOld> {
        return repository.findAll()
    }

    fun getById(id: String): MsSqlCityOld {
        return repository.getById(id)
    }

}