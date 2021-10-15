package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "ssr_types")
@Entity
open class SsrType {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "ssr_code", nullable = false, length = 4)
    open var ssrCode: String? = null

    @Column(name = "description", nullable = false, length = 250)
    open var description: String? = null

    @Column(name = "is_alert", nullable = false)
    open var isAlert: Boolean? = false

    @Column(name = "alert_text", length = 250)
    open var alertText: String? = null

    @Column(name = "is_meal", nullable = false)
    open var isMeal: Boolean? = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}