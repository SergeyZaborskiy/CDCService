package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "waypoint_types")
@Entity
open class WaypointType {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @Column(name = "is_start", nullable = false)
    open var isStart: Boolean? = false

    @Column(name = "is_finish", nullable = false)
    open var isFinish: Boolean? = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}