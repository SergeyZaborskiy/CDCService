package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "route_types")
@Entity
open class RouteType {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @Column(name = "lit_en", nullable = false, length = 1)
    open var litEn: String? = null

    @Column(name = "lit", nullable = false, length = 1)
    open var lit: String? = null

    @Column(name = "is_work", nullable = false)
    open var isWork: Boolean? = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}