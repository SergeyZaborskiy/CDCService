package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airline
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.AirlineRepository

@Service
class AirlinePostgreService(private val repository: AirlineRepository) {

    fun getAll(): List<Airline> {
        return repository.findAll()
    }

    fun getById(id: Int): Airline {
        return repository.getById(id)
    }

    fun saveOrUpdate(airline: Airline) {
        repository.save(airline)
    }

    fun existsByInnerId(innerId: Int): Boolean {
        return repository.existsByInnerId(innerId)
    }
}