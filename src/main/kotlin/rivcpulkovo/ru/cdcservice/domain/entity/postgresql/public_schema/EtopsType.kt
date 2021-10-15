package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "etops_types")
@Entity
open class EtopsType {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @Column(name = "is_etops", nullable = false)
    open var isEtops: Boolean? = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}