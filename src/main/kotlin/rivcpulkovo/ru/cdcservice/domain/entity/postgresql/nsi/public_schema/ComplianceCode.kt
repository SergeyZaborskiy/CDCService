package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlComplianceCodesTraffic
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "compliance_codes")
@Entity
open class ComplianceCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "code", nullable = false, length = 3)
    open var code: String? = null

    @Column(name = "code_en", nullable = false, length = 3)
    open var codeEn: String? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "description", nullable = false)
    open var description: String? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    constructor(data:MsSqlComplianceCodesTraffic) {
        this.code = data.ru
        this.codeEn = data.en
        this.name = data.note?.substringBefore(" ")
        this.description = data.note
        this.creationDate = LocalDateTime.now()
        this.editorId = 1
    }
}