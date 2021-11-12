package rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlCountry

@Repository
interface MsSqlCountryRepository : JpaRepository<MsSqlCountry, String> {

    override fun getById(id: String): MsSqlCountry

    fun existsByApC(apC: String): Boolean
}