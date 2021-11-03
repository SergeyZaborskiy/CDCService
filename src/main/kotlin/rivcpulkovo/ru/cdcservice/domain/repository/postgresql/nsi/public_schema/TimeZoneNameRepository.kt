package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.TimeZoneName

interface TimeZoneNameRepository : JpaRepository<TimeZoneName, Int> {

    fun existsByCountryIdAndCode(countryId: Int, code: String): Boolean

    fun getByCountryIdAndCode(countryId: Int, code: String): TimeZoneName

    fun getByNameAndCode(name: String, code: String): TimeZoneName
}