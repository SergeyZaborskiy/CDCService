package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "etops_types")
@Entity
open class EtopsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @Column(name = "is_etops", nullable = false)
    open var isEtops: Boolean? = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}