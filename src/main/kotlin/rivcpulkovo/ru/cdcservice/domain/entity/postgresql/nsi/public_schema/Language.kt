package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "languages")
@Entity
open class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "code2", nullable = false, length = 2)
    open var code2: String = "нд"

    @Column(name = "code3", nullable = false, length = 3)
    open var code3: String = "нд"

    @Column(name = "lang_name", nullable = false, length = 500)
    open var langName: String = "нд"

    @Column(name = "lang_name_en", nullable = false, length = 500)
    open var langNameEn: String = "нд"

    @Column(name = "is_system_default_lang", nullable = false)
    open var isSystemDefaultLang: Boolean = false

    @Column(name = "is_system_lang", nullable = false)
    open var isSystemLang: Boolean = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int = 0

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null
}