package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.Instant
import javax.persistence.*

@Table(name = "languages")
@Entity
open class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "code2", nullable = false, length = 2)
    open var code2: String? = null

    @Column(name = "code3", nullable = false, length = 3)
    open var code3: String? = null

    @Column(name = "lang_name", nullable = false, length = 500)
    open var langName: String? = null

    @Column(name = "lang_name_en", nullable = false, length = 500)
    open var langNameEn: String? = null

    @Column(name = "is_system_default_lang", nullable = false)
    open var isSystemDefaultLang: Boolean? = false

    @Column(name = "is_system_lang", nullable = false)
    open var isSystemLang: Boolean? = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null
}