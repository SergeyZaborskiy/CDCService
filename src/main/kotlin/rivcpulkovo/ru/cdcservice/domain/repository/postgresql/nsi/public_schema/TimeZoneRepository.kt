package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZone

@Repository
interface TimeZoneRepository : JpaRepository<TimeZone, Int> {
    fun existsByInnerId(innerId: Int): Boolean
}