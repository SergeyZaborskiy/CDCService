package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "aircraft_types")
@Entity
open class AircraftType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @Column(name = "iata", nullable = false, length = 3)
    open var iata: String? = null

    @Column(name = "native", nullable = false, length = 3)
    open var _native: String? = null

    @Column(name = "icao", nullable = false, length = 4)
    open var icao: String? = null

    @Column(name = "native_icao", nullable = false, length = 4)
    open var nativeIcao: String? = null

    @Column(name = "num_code", nullable = false)
    open var numCode: Int? = null

    @Column(name = "short_name", nullable = false)
    open var shortName: String? = null

    @Column(name = "full_name", nullable = false)
    open var fullName: String? = null

    @Column(name = "seats", nullable = false)
    open var seats: Int? = null

    @Column(name = "is_helicopter", nullable = false)
    open var isHelicopter: Boolean? = false

    @Column(name = "dow", nullable = false)
    open var dow: Int? = null

    @Column(name = "law", nullable = false)
    open var law: Int? = null

    @Column(name = "mtow", nullable = false)
    open var mtow: Int? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null

    @Column(name = "md", nullable = false, length = 1)
    open var md: String? = null

    @Column(name = "native_md", nullable = false, length = 1)
    open var nativeMd: String? = null

    @Column(name = "description", nullable = false, length = 1000)
    open var description: String? = null
}