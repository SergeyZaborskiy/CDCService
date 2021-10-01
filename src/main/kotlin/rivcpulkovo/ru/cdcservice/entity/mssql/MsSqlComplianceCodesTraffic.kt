package rivcpulkovo.ru.cdcservice.entity.mssql

import java.time.Instant
import javax.persistence.*

@Table(name = "ComplianceCodesTraffic")
@Entity
open class MsSqlComplianceCodesTraffic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "RU", nullable = false, length = 1)
    open var ru: String? = null

    @Column(name = "EN", nullable = false, length = 1)
    open var en: String? = null

    @Column(name = "Note", nullable = false, length = 100)
    open var note: String? = null

    @Column(name = "SortOrder", nullable = false)
    open var sortOrder: Int? = null

    @Column(name = "Cop", nullable = false)
    open var cop: Int? = null

    @Column(name = "dk", nullable = false)
    open var dk: Instant? = null
}