package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.City
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.CityRepository

@Service
class CityService(private val repository: CityRepository) {

    fun getAll(): List<City> {
        return repository.findAll()
    }

    fun getById(id: Int): City {
        return repository.getById(id)
    }

    fun saveOrUpdate(data: City) {
        repository.save(data)
    }

    fun existByInnerId(innerId: Int): Boolean {
        return repository.existsByInnerId(innerId)
    }

    fun getByInnerId(innerId: Int): City {
        return repository.getByInnerId(innerId)
    }

    fun getByCountryId(countryId: Int): List<City> {
        return repository.getByCountryId(countryId)
    }

    fun existsByCountryId(countryId: Int): Boolean {
        return repository.existsByCountryId(countryId)
    }

}