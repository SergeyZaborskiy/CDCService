package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.City

@Repository
interface CityRepository : JpaRepository<City, Int> {

    fun existsByInnerId(innerId: Int): Boolean

    fun getByInnerId(innerId: Int): City

    fun getByCountryId(countryId: Int): List<City>

    fun existsByCountryId(countryId: Int): Boolean
}