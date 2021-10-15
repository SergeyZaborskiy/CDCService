package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.math.BigDecimal
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "time_zones")
@Entity
open class TimeZone {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "inner_id", nullable = false)
    open var innerId: Int? = null

    @Column(name = "country_id", nullable = false)
    open var countryId: Int? = null

    @Column(name = "code", nullable = false, length = 3)
    open var code: String? = null

    @Column(name = "delta", nullable = false, precision = 131089)
    open var delta: BigDecimal? = null

    @Column(name = "summer_delta", nullable = false, precision = 131089)
    open var summerDelta: BigDecimal? = null

    @Column(name = "start_utc", nullable = false)
    open var startUtc: Instant? = null

    @Column(name = "end_utc", nullable = false)
    open var endUtc: Instant? = null

    @Column(name = "start_loc", nullable = false)
    open var startLoc: Instant? = null

    @Column(name = "end_loc", nullable = false)
    open var endLoc: Instant? = null

    @Column(name = "creation_date")
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}