package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlTimezone
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi.MsSqlTimezoneRepository

@Service
class MsSqlTimezoneService(private val repository: MsSqlTimezoneRepository) {

    fun getAll(): List<MsSqlTimezone> {
        return repository.findAll()
    }

    fun getById(id: Int): MsSqlTimezone {
        return repository.getById(id)
    }
}