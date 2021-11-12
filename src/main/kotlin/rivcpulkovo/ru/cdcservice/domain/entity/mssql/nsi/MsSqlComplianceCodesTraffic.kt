package rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Proxy
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "ComplianceCodesTraffic")
@Entity
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
open class MsSqlComplianceCodesTraffic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

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
    open var dk: LocalDateTime? = null

}