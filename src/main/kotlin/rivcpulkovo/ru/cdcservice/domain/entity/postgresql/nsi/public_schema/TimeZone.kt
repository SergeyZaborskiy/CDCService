package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlTimezone
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Table(name = "time_zones")
@Entity
open class TimeZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "inner_id", nullable = false)
    open var innerId: Int = 0

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    open var country: Country? = null

    @Column(name = "country_id", nullable = false)
    open var countryId: Int = 0

    @Column(name = "code", nullable = false, length = 3)
    open var code: String = "нд"

    @Column(name = "delta", nullable = false, precision = 131089)
    open var delta: BigDecimal? = null

    @Column(name = "summer_delta", nullable = false, precision = 131089)
    open var summerDelta: BigDecimal? = null

    @Column(name = "start_utc", nullable = false)
    open var startUtc: LocalDateTime? = null

    @Column(name = "end_utc", nullable = false)
    open var endUtc: LocalDateTime? = null

    @Column(name = "start_loc", nullable = false)
    open var startLoc: LocalDateTime? = null

    @Column(name = "end_loc", nullable = false)
    open var endLoc: LocalDateTime? = null

    @Column(name = "creation_date")
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int = 0


/*    @OneToMany(mappedBy = "time_zones", fetch = FetchType.LAZY)
    open var airport: MutableList<Airport>? = null*/

    constructor(data: MsSqlTimezone, countryId: Int?) {
        this.innerId = data.id
        this.countryId = countryId?: 0
        this.code = data.tz
        this.delta = data.standVar
        this.summerDelta = data.dstVar
        this.startUtc = convertDSTtoTimestamp(data.utcDs, convertStrToSecond(data.utcTs))
        this.endUtc = convertDSTtoTimestamp(data.utcDe, convertStrToSecond(data.utcTe))
        this.startLoc = convertDSTtoTimestamp(data.locDs, convertStrToSecond(data.locTs))
        this.endLoc = convertDSTtoTimestamp(data.locDe, convertStrToSecond(data.locTe))
        this.creationDate = LocalDateTime.now()
        this.correctionDate = data.dk ?: LocalDateTime.now()
        this.editorId = data.cop ?: 0
    }

    private fun convertStrToSecond(str: String?): Long {
        if (str.isNullOrBlank()) {
            return 0
        }
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HHmm")
        val temp = LocalTime.parse(str, formatter)
        return temp.toSecondOfDay().toLong()
    }

    private fun convertDSTtoTimestamp(date: LocalDateTime?, second: Long?): LocalDateTime? {
        return date?.plusSeconds(second!!)
    }

}