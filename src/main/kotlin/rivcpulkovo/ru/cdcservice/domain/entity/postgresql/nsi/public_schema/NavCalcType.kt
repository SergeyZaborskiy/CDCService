package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "nav_calc_types")
@Entity
open class NavCalcType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @Column(name = "system_name", nullable = false, length = 100)
    open var systemName: String? = null

    @Column(name = "in_use", nullable = false)
    open var inUse: Boolean? = false

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}