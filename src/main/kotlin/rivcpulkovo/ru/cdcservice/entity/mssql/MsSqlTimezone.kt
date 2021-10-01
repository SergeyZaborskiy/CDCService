package rivcpulkovo.ru.cdcservice.entity.mssql

import java.math.BigDecimal
import java.time.Instant
import javax.persistence.*

@Table(
    name = "TIMEZONE", indexes = [
        Index(name = "TIMEZONE_CC_TZ_UTCDS", columnList = "cc, TZ, UTC_DS"),
        Index(name = "TIMEZONE_CC_TZ_LOCDS", columnList = "cc, TZ, LOC_DS")
    ]
)
@Entity
open class MsSqlTimezone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "cc", nullable = false)
    open var cc: MsSqlCountry? = null

    @Column(name = "TZ", nullable = false, length = 2)
    open var tz: String? = null

    @Column(name = "STAND_VAR", nullable = false, precision = 6, scale = 2)
    open var standVar: BigDecimal? = null

    @Column(name = "UTC_TS", nullable = false, length = 4)
    open var utcTs: String? = null

    @Column(name = "UTC_DS")
    open var utcDs: Instant? = null

    @Column(name = "UTC_TE", nullable = false, length = 4)
    open var utcTe: String? = null

    @Column(name = "UTC_DE")
    open var utcDe: Instant? = null

    @Column(name = "DST_VAR", nullable = false, precision = 6, scale = 2)
    open var dstVar: BigDecimal? = null

    @Column(name = "LOC_TS", nullable = false, length = 4)
    open var locTs: String? = null

    @Column(name = "LOC_DS")
    open var locDs: Instant? = null

    @Column(name = "LOC_TE", nullable = false, length = 4)
    open var locTe: String? = null

    @Column(name = "LOC_DE")
    open var locDe: Instant? = null

    @Column(name = "dk", nullable = false)
    open var dk: Instant? = null

    @Column(name = "cop", nullable = false)
    open var cop: Int? = null
}