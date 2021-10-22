package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "port_taxi_times")
@Entity
open class PortTaxiTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "port_id", nullable = false)
    open var port: Airport? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ac_type_id", nullable = false)
    open var acType: AircraftType? = null

    @Column(name = "taxi_time_dep", nullable = false)
    open var taxiTimeDep: Int? = null

    @Column(name = "taxi_time_arr", nullable = false)
    open var taxiTimeArr: Int? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}