package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "port_taxi_times")
@Entity
open class PortTaxiTime {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "port_id", nullable = false)
    open var portId: Int? = null

    @Column(name = "ac_type_id", nullable = false)
    open var acTypeId: Int? = null

    @Column(name = "taxi_time_dep", nullable = false)
    open var taxiTimeDep: Int? = null

    @Column(name = "taxi_time_arr", nullable = false)
    open var taxiTimeArr: Int? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}