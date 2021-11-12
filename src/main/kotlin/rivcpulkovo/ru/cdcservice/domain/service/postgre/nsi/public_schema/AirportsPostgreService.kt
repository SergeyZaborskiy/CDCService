package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.AirportRepository

@Service
class AirportsPostgreService(private val repository: AirportRepository) {

    fun getAll(): List<Airport> {
        return repository.findAll()
    }

    fun getById(airport_id: Int): Airport {
        return repository.getById(airport_id)
    }

    fun existsByInnerId(innerId: Int?): Boolean {
        return repository.existsByInnerId(innerId)
    }

    fun findByInnerId(innerId: Int?): Airport {
        return repository.findByInnerId(innerId)
    }

    fun saveOrUpdate(airport: Airport) {
        repository.save(airport)
    }

    fun findByCityName(cityId: Int): List<Airport> {
        return repository.findByCityId(cityId)
    }

    fun findByCountryName(countryId: Int): List<Airport> {
        return repository.findByCountryId(countryId)
    }

}