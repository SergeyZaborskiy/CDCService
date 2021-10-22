package rivcpulkovo.ru.cdcservice.domain.entity.mssql

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Proxy
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Table(
    name = "TYPE_VS", indexes = [
        Index(name = "IDX_TYPE_VS_TS", columnList = "TS"),
        Index(name = "IDX_TYPE_VS_TS_M", columnList = "TS_M"),
        Index(name = "idx_TYPE_VS_TSM_MDM", columnList = "TS_M, MD_M", unique = true),
        Index(name = "TYPE_VS_TS_NU", columnList = "TS_NU"),
        Index(name = "TYPE_VS_TS_NO_UK", columnList = "TS_NO", unique = true)
    ]
)
@Entity
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
open class MsSqlAirctaftType {
    @EmbeddedId
    open var id: MsSqlAirctaftTypeId? = null

    @Column(name = "TS_NO")
    open var tsNo: Int? = null

    @Column(name = "TS_NU")
    open var tsNu: Int? = null

    @Column(name = "TS_M", nullable = false, length = 3)
    open var tsM: String? = null

    @Column(name = "MD_M", nullable = false)
    open var mdM: Char? = null

    @Column(name = "OWN", nullable = false)
    open var own: Char? = null

    @Column(name = "PRIM", nullable = false, length = 5)
    open var prim: String? = null

    @Column(name = "TC", nullable = false, length = 2)
    open var tc: String? = null

    @Column(name = "NAME_TYP", nullable = false, length = 6)
    open var nameTyp: String? = null

    @Column(name = "NAME_M", nullable = false, length = 8)
    open var nameM: String? = null

    @Column(name = "PT", nullable = false)
    open var pt: Char? = null

    @Column(name = "KR", nullable = false, length = 3)
    open var kr: String? = null

    @Column(name = "KM", nullable = false, length = 3)
    open var km: String? = null

    @Column(name = "VR_V", nullable = false)
    open var vrV: Int? = null

    @Column(name = "VR_P", nullable = false)
    open var vrP: Int? = null

    @Column(name = "VR_VM", nullable = false)
    open var vrVm: Int? = null

    @Column(name = "VR_PM", nullable = false)
    open var vrPm: Int? = null

    @Column(name = "VR_MIN", nullable = false, length = 4)
    open var vrMin: String? = null

    @Column(name = "VR_TF", nullable = false, length = 4)
    open var vrTf: String? = null

    @Column(name = "SS", nullable = false, length = 4)
    open var ss: String? = null

    @Column(name = "MM", nullable = false, length = 4)
    open var mm: String? = null

    @Column(name = "MS", nullable = false, length = 4)
    open var ms: String? = null

    @Column(name = "SM", nullable = false, length = 4)
    open var sm: String? = null

    @Column(name = "NORM_PR", nullable = false, precision = 5)
    open var normPr: BigDecimal? = null

    @Column(name = "AZ", nullable = false, precision = 4, scale = 1)
    open var az: BigDecimal? = null

    @Column(name = "MW", nullable = false, precision = 6)
    open var mw: BigDecimal? = null

    @Column(name = "EW", nullable = false, precision = 6)
    open var ew: BigDecimal? = null

    @Column(name = "PW", nullable = false, precision = 6)
    open var pw: BigDecimal? = null

    @Column(name = "NT", nullable = false, precision = 2)
    open var nt: BigDecimal? = null

    @Column(name = "NL", nullable = false, precision = 2)
    open var nl: BigDecimal? = null

    @Column(name = "NW", nullable = false, precision = 2)
    open var nw: BigDecimal? = null

    @Column(name = "PR", nullable = false, precision = 5)
    open var pr: BigDecimal? = null

    @Column(name = "NS", nullable = false, precision = 2)
    open var ns: BigDecimal? = null

    @Column(name = "LG", nullable = false, precision = 6, scale = 2)
    open var lg: BigDecimal? = null

    @Column(name = "LB", nullable = false, precision = 6, scale = 2)
    open var lb: BigDecimal? = null

    @Column(name = "BE", nullable = false, precision = 2)
    open var be: BigDecimal? = null

    @Column(name = "NAME_L", nullable = false, length = 30)
    open var nameL: String? = null

    @Column(name = "CL", nullable = false, length = 10)
    open var cl: String? = null

    @Column(name = "NAME_MOD", nullable = false, length = 25)
    open var nameMod: String? = null

    @Column(name = "TS4_M", nullable = false, length = 4)
    open var ts4M: String? = null

    @Column(name = "TS4", nullable = false, length = 4)
    open var ts4: String? = null

    @Column(name = "DK", nullable = false)
    open var dk: LocalDateTime? = null

    @Column(name = "NAME3", nullable = false, precision = 3)
    open var name3: BigDecimal? = null

    @Column(name = "TYPG", nullable = false)
    open var typg: Char? = null

    @Column(name = "OT", nullable = false)
    open var ot: Char? = null

    @Column(name = "TOPL_MAX", nullable = false, precision = 6)
    open var toplMax: BigDecimal? = null

    @Column(name = "TRAP", nullable = false)
    open var trap: Int? = null

    @Column(name = "FZ", nullable = false)
    open var fz: Char? = null

    @Column(name = "CAT_CODE", nullable = false)
    open var catCode: Char? = null

    @Column(name = "WINGSPAN", nullable = false, precision = 8, scale = 4)
    open var wingspan: BigDecimal? = null

    @Column(name = "LENGTH", nullable = false, precision = 8, scale = 4)
    open var length: BigDecimal? = null

    @Column(name = "cop", nullable = false)
    open var cop: Int? = null

    @Column(name = "NAME_FULL", nullable = false, length = 50)
    open var nameFull: String? = null

    @Column(name = "ALIEN", nullable = false)
    open var alien: Boolean? = false
}