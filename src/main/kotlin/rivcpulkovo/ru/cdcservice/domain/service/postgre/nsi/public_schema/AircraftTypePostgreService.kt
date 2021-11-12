package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.AircraftType
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.AircraftTypeRepository

@Service
class AircraftTypePostgreService(private val repository: AircraftTypeRepository) {

    fun existsByNativeAndMd(native: String, md: String): Boolean {
        return repository.existsByNativeAndMd(native, md)
    }

    fun findByNative(native: String): AircraftType {
        return repository.findByNative(native)
    }

    fun saveOrUpdate(aircraftType: AircraftType) {
        repository.save(aircraftType)
    }
}