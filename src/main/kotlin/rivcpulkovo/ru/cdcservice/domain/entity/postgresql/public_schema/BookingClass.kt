package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "booking_classes")
@Entity
open class BookingClass {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "code", nullable = false, length = 1)
    open var code: String? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @Column(name = "ac_id")
    open var acId: Int? = null

    @Column(name = "service_class", nullable = false, length = 1)
    open var serviceClass: String? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}