package rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Country

@Repository
interface CountryRepository : JpaRepository<Country, Int> {
    fun existsByAlpha2(alpha2: String?): Boolean

    fun getByAlpha2(alpha2: String?): Country
}