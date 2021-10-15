package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "countries")
@Entity
open class Country {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "alpha2", nullable = false, length = 2)
    open var alpha2: String? = null

    @Column(name = "alpha3", nullable = false, length = 3)
    open var alpha3: String? = null

    @Column(name = "\"num_сс\"", nullable = false, length = 3)
    open var numСс: String? = null

    @Column(name = "name", nullable = false, length = 1000)
    open var name: String? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null

    @Column(name = "default_lang_id", nullable = false)
    open var defaultLangId: Int? = null
}