package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "message_types")
@Entity
open class MessageType {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "short_name", nullable = false, length = 10)
    open var shortName: String? = null

    @Column(name = "full_name", length = 150)
    open var fullName: String? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}