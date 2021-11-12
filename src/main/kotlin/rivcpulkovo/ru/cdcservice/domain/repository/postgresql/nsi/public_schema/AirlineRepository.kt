package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airline

interface AirlineRepository : JpaRepository<Airline, Int> {

    fun existsByInnerId (innerId: Int): Boolean
}