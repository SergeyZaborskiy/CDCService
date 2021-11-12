package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlCountry
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Country
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.CountryRepository

@Service
class CountryService(private val repository: CountryRepository) {
    fun getAll(): List<Country> {
        return repository.findAll()
    }

    fun getById(id: Int): Country {
        return repository.getById(id)
    }

    fun saveOrUpdate(data: Country) {
        repository.save(data)
    }

    fun getByAlpha2(alpha2: String): Country {
        return repository.getByAlpha2(alpha2)
    }

    fun existsByAlpha2(alpha2: String): Boolean {
        return repository.existsByAlpha2(alpha2)
    }

}