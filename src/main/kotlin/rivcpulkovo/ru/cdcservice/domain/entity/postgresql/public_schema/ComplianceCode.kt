package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "compliance_codes")
@Entity
open class ComplianceCode {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "code", nullable = false, length = 3)
    open var code: String? = null

    @Column(name = "code_en", nullable = false, length = 3)
    open var codeEn: String? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "description", nullable = false)
    open var description: String? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null
}