package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirctaftType
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi.MsSqlAirctaftTypeRepository

@Service
class MsSqlAircraftTypeService(private val repository: MsSqlAirctaftTypeRepository) {

    fun getByTsAndMd(ts: String, md: String): MsSqlAirctaftType {
        return repository.getByTsAndMd(ts, md)
    }

    fun getByTs(ts: String): MsSqlAirctaftType {
        return getByTs(ts)
    }

    fun getById(ts: String): MsSqlAirctaftType {
        return repository.getById(ts)
    }

    fun getAll(): List<MsSqlAirctaftType> {
        return repository.findAll()
    }

}