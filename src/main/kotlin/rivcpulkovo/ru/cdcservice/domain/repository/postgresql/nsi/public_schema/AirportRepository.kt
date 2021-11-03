package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport

@Repository
interface AirportRepository : JpaRepository<Airport, Int> {

    fun existsByInnerId (innerId: Int?) : Boolean

    fun findByCityId(cityId: Int): List<Airport>

    fun findByCountryId(countryId: Int): List<Airport>

}