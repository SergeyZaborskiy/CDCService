package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirport
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi.MsSqlAirportRepository

@Service
class MsSqlAirportService(private val repository: MsSqlAirportRepository) {

    fun getAll(): List<MsSqlAirport> {
        return repository.findAll()
    }

    fun getById(id: Int): MsSqlAirport {
        return repository.getById(id)
    }
}