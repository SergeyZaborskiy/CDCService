package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCountry
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

    fun saveFromMssqlById(country: MsSqlCountry): String {
        return if (repository.existsByAlpha2(country.id)) {
            "Already have one"
        } else {
            val temp: Country = Country(country, 1)
            repository.save(temp)
            "Save done"
        }
    }

    fun saveAllFromMssql(countries: List<MsSqlCountry>): String {
        for (country in countries) {
            if (repository.existsByAlpha2(country.id)) {
                continue
            } else {
                val temp: Country = Country(country, 1)
                repository.save(temp)
            }
        }
        return "Done"
    }

}