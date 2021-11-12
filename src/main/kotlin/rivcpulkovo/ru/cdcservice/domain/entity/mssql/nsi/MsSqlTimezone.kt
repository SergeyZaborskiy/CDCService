package rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Proxy
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Table(
    name = "TIMEZONE", indexes = [
        Index(name = "TIMEZONE_CC_TZ_UTCDS", columnList = "cc, TZ, UTC_DS"),
        Index(name = "TIMEZONE_CC_TZ_LOCDS", columnList = "cc, TZ, LOC_DS")
    ]
)
@Entity
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
open class MsSqlTimezone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @ManyToOne(optional = false)
    @JoinColumn(name = "cc", nullable = false, insertable = false, updatable = false)
    open var country: MsSqlCountry? = null

    @Column(name = "cc", nullable = false)
    open var cc: String = "AA"

    @Column(name = "TZ", nullable = false, length = 2)
    open var tz: String = ""

    @Column(name = "STAND_VAR", nullable = false, precision = 6, scale = 2)
    open var standVar: BigDecimal? = null

    @Column(name = "UTC_TS", nullable = false, length = 4)
    open var utcTs: String? = null

    @Column(name = "UTC_DS")
    open var utcDs: LocalDateTime? = null

    @Column(name = "UTC_TE", nullable = false, length = 4)
    open var utcTe: String? = null

    @Column(name = "UTC_DE")
    open var utcDe: LocalDateTime? = null

    @Column(name = "DST_VAR", nullable = false, precision = 6, scale = 2)
    open var dstVar: BigDecimal? = null

    @Column(name = "LOC_TS", nullable = false, length = 4)
    open var locTs: String? = null

    @Column(name = "LOC_DS")
    open var locDs: LocalDateTime? = null

    @Column(name = "LOC_TE", nullable = false, length = 4)
    open var locTe: String? = null

    @Column(name = "LOC_DE")
    open var locDe: LocalDateTime? = null

    @Column(name = "dk", nullable = false)
    open var dk: LocalDateTime? = null

    @Column(name = "cop", nullable = false)
    open var cop: Int? = null
}