package rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema

import org.springframework.stereotype.Service
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Language
import rivcpulkovo.ru.cdcservice.domain.repository.postgresql.nsi.public_schema.LanguageRepository

@Service
class LanguageService(private val repository: LanguageRepository) {

    fun getAll(): List<Language> {
        return repository.findAll()
    }

    fun getById(languageId: Int): Language {
        return  repository.getById(languageId)
    }
}