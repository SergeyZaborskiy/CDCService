package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "airlines")
@Entity
open class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    open var country: Country? = null

    @Column(name = "inner_id", nullable = false)
    open var innerId: Int? = null

    @Column(name = "iata", nullable = false, length = 2)
    open var iata: String? = null

    @Column(name = "native", nullable = false, length = 2)
    open var _native: String? = null

    @Column(name = "icao", nullable = false, length = 3)
    open var icao: String? = null

    @Column(name = "num_al", nullable = false, length = 3)
    open var numAl: String? = null

    @Column(name = "native_icao", nullable = false, length = 3)
    open var nativeIcao: String? = null

    @Column(name = "short_name", nullable = false)
    open var shortName: String? = null

    @Column(name = "full_name", nullable = false, length = 500)
    open var fullName: String? = null

    @Column(name = "start_date", nullable = false)
    open var startDate: LocalDateTime? = null

    @Column(name = "end_date", nullable = false)
    open var endDate: LocalDateTime? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}