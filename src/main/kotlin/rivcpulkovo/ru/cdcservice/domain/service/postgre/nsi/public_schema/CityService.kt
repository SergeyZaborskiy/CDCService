package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCity
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCountry
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.City
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Country
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


    fun saveFromMssqlById(city: MsSqlCity): String {
        return if (repository.existsById(city.id!!)) {
            "Already have one"
        } else {
            val temp: City = City(city, 1,1, false)
            repository.save(temp)
            "Save done"
        }
    }

    fun saveAllFromMssql(cities: List<MsSqlCity>): String {
        for (city in cities) {
            if (repository.existsById(city.id!!)) {
                continue
            } else {
                val temp: City = City(city, 1,1, false)
                repository.save(temp)
            }
        }
        return "Done"
    }



}