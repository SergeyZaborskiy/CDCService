package rivcpulkovo.ru.cdcservice.domain.repository.postgresql;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema.WaypointType

@Repository
interface WaypointTypeRepository : JpaRepository<WaypointType, Int> {
}