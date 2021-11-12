package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.AircraftType

@Repository
interface AircraftTypeRepository : JpaRepository<AircraftType, Int> {

    fun existsByNativeAndMd(native: String, md: String): Boolean

    fun findByNative(native: String): AircraftType
}