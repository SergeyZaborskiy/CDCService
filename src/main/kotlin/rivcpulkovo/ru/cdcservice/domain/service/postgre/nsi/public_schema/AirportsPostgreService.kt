package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlAirport
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.AirportRepository

@Service
@Transactional("ufdTransactionManager")
class AirportsPostgreService(private val repository: AirportRepository) {

    fun getAll(): List<Airport>{
        return repository.findAll()
    }

    fun getById(airport_id: Int): Airport {
        return repository.getById(airport_id)
    }

    fun saveFromMssqlById(airport: MsSqlAirport): String {
        return if (repository.existsAirportByInnerId(airport.id)){
            "Already have one"
        } else {
            val temp: Airport = Airport(airport)
            repository.save(temp)
            "Save done"
        }
    }

    fun saveAllFromMssql(airports: List<MsSqlAirport>): String {
        for (airport in airports) {
            if (repository.existsAirportByInnerId(airport.id)) {
                continue
            } else {
                val temp: Airport = Airport(airport)
                repository.save(temp)
            }
        }
        return "Done"
    }
}