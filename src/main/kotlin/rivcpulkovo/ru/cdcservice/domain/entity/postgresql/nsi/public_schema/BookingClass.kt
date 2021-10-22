package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "booking_classes")
@Entity
open class BookingClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "code", nullable = false, length = 1)
    open var code: String? = null

    @Column(name = "name", nullable = false, length = 50)
    open var name: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ac_id")
    open var ac: Airline? = null

    @Column(name = "service_class", nullable = false, length = 1)
    open var serviceClass: String? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}