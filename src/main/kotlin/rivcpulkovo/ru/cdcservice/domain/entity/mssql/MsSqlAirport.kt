package rivcpulkovo.ru.cdcservice.domain.entity.mssql

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Proxy
import java.time.LocalDateTime
import javax.persistence.*

@Table(
    name = "PORT_N", indexes = [
        Index(name = "IDX_PORT_N_AP_IATA", columnList = "AP, IATA"),
        Index(name = "PORT_N_IATA", columnList = "IATA"),
        Index(name = "idx_PORT_N_IK_IK_R", columnList = "IK, IK_R"),
        Index(name = "PORT_N_IK_R", columnList = "IK_R"),
        Index(name = "PORT_N_NAME8", columnList = "NAME_8"),
        Index(name = "CC_PORT_N", columnList = "cc"),
        Index(name = "IX_PORT_N_missing_1912", columnList = "cc"),
        Index(name = "PORT_N_NL", columnList = "NL"),
        Index(name = "IX_PORT_N_TDP2_AP_IATA", columnList = "TDP2"),
        Index(name = "PORT_N_AP", columnList = "AP"),
        Index(name = "IDX_PORT_N_ID_CITY", columnList = "ID_CITY")
    ]
)
@Entity
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
open class MsSqlAirport {
    @Id
    @Column(name = "ID_PORT", nullable = false)
    open var id: Int? = null

    @Column(name = "AP", nullable = false, length = 3)
    open var ap: String? = null

    @Column(name = "IATA", nullable = false, length = 3)
    open var iata: String? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_CITY", nullable = false)
    open var idCity: MsSqlCity? = null

    @Column(name = "IK_R", nullable = false, length = 4)
    open var ikR: String? = null

    @Column(name = "IK", nullable = false, length = 4)
    open var ik: String? = null

    @Column(name = "NAME_8", nullable = false, length = 8)
    open var name8: String? = null

    @Column(name = "TDP2", nullable = false, length = 8)
    open var tdp2: String? = null

    @Column(name = "NAME_AP", nullable = false, length = 30)
    open var nameAp: String? = null

    @Column(name = "NL", nullable = false, length = 25)
    open var nl: String? = null

    @Column(name = "REG", nullable = false, length = 2)
    open var reg: String? = null

    @ManyToOne(optional = false)
    @JoinColumn(name = "cc", nullable = false)
    open var cc: MsSqlCountry? = null

    @Column(name = "tz", nullable = false, length = 2)
    open var tz: String? = null

    @Column(name = "ds", nullable = false)
    open var ds: LocalDateTime? = null

    @Column(name = "dk", nullable = false)
    open var dk: LocalDateTime? = null

    @Column(name = "REM", nullable = false, length = 25)
    open var rem: String? = null

    @Column(name = "fil", nullable = false)
    open var fil: Char? = null

    @Column(name = "cop", nullable = false)
    open var cop: Int? = null

    @Column(name = "MIL", length = 4)
    open var mil: String? = null

    @Column(name = "MILM", length = 4)
    open var milm: String? = null

    @Column(name = "LAT", length = 10)
    open var lat: String? = null

    @Column(name = "LONG", length = 10)
    open var _long: String? = null
}