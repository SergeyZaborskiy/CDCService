package rivcpulkovo.ru.cdcservice.domain.service.mssql

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlComplianceCodesTraffic
import rivcpulkovo.ru.cdcservice.domain.repository.mssql.MsSqlComplianceCodesTrafficRepository

@Service
@Transactional("nsiTransactionManager")
class MsSqlComplianceCodeService(private val repository: MsSqlComplianceCodesTrafficRepository) {

    fun getAll(): List<MsSqlComplianceCodesTraffic> {
        return repository.findAll()
    }

    fun getById(id: Int): MsSqlComplianceCodesTraffic {
        return repository.getById(id)
    }

}