package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirlines
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi.MsSqlAirlinesRepository

@Service
class MsSqlAirlineService(private val repository: MsSqlAirlinesRepository) {

    fun getAll(): List<MsSqlAirlines> {
        return  repository.findAll()
    }

    fun getById(id: Int): MsSqlAirlines {
        return  repository.getById(id)
    }
}

