package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZoneName
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.TimeZoneNameRepository

@Service
class TimeZoneNameService(private val repository: TimeZoneNameRepository) {
    fun getAll(): List<TimeZoneName> {
        return repository.findAll()
    }

    fun getById(id: Int): TimeZoneName {
        return repository.getById(id)
    }

    fun saveOrUpdate(data: TimeZoneName) {
        repository.save(data)
    }

    fun existsByCountryIdAndCode(countryId: Int, code: String): Boolean {
        return repository.existsByCountryIdAndCode(countryId, code)
    }

    fun getByCountryIdAndCode(countryId: Int, code: String): TimeZoneName {
        return repository.getByCountryIdAndCode(countryId, code)
    }

    fun getByNameAndCode(name: String, code: String): TimeZoneName {
        return repository.getByNameAndCode(name, code)
    }

/*    fun saveFromMssqlById(timeZone: MsSqlTimezone, cityId: Int): String {
        return if (repository.existsByInnerId(timeZone.id!!)) {
            "Already have one"
        } else {
            val temp = TimeZone(timeZone, cityId)
            repository.save(temp)
            "Save done"
        }
    }*/
}