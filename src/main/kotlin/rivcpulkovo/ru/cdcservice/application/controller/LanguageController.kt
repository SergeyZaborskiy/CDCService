package rivcpulkovo.ru.cdcservice.application.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Language
import rivcpulkovo.ru.cdcservice.domain.service.postgre.nsi.public_schema.LanguageService

@RestController
@RequestMapping("api/v1/pg/languages")
class LanguageController(private val pgLanguageService: LanguageService) {
    @GetMapping
    fun getAll(): List<Language> {
        return pgLanguageService.getAll()
    }

    @GetMapping("{languageId}")
    fun getById(@PathVariable languageId: Int): Language {
        return pgLanguageService.getById(languageId)
    }

}