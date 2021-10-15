package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "cities")
@Entity
open class City {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "country_id", nullable = false)
    open var countryId: Int? = null

    @Column(name = "inner_id", nullable = false)
    open var innerId: Int? = null

    @Column(name = "iata", nullable = false, length = 3)
    open var iata: String? = null

    @Column(name = "native", nullable = false, length = 3)
    open var _native: String? = null

    @Column(name = "short_name", nullable = false, length = 100)
    open var shortName: String? = null

    @Column(name = "full_name", nullable = false, length = 1000)
    open var fullName: String? = null

    @Column(name = "start_date", nullable = false)
    open var startDate: Instant? = null

    @Column(name = "end_date", nullable = false)
    open var endDate: Instant? = null

    @Column(name = "is_capital", nullable = false)
    open var isCapital: Boolean? = false

    @Column(name = "time_zone_inner_id", nullable = false)
    open var timeZoneInnerId: Int? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null
}