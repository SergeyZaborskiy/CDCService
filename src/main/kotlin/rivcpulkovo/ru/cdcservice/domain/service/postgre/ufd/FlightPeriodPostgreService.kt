package rivcpulkovo.ru.cdcservice.domain.service.postgre.ufd

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.ufd.public.FlightPeriod
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.ufd.FlightPeriodRepository


@Service
class FlightPeriodPostgreService(private val repository: FlightPeriodRepository) {

    fun getAll(): List<FlightPeriod> {
        return repository.findAll()
    }

    fun getById(id: Int): FlightPeriod {
        return repository.getById(id)
    }

    fun saveOrUpdate(flightPeriod: FlightPeriod) {
        repository.save(flightPeriod)
    }
}