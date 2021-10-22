package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlTimezone
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZone
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.TimeZoneRepository

@Service
class TimezoneService(private val repository: TimeZoneRepository) {
    fun getAll(): List<TimeZone> {
        return repository.findAll()
    }

    fun getById(id: Int): TimeZone {
        return repository.getById(id)
    }

    fun saveOrUpdate(data: TimeZone) {
        repository.save(data)
    }

    fun existsByInnerId(id: Int): Boolean {
        return repository.existsByInnerId(id)
    }

    fun saveFromMssqlById(timeZone: MsSqlTimezone, cityId: Int): String {
        return if (repository.existsByInnerId(timeZone.id!!)) {
            "Already have one"
        } else {
            val temp = TimeZone(timeZone, cityId)
            repository.save(temp)
            "Save done"
        }
    }
}