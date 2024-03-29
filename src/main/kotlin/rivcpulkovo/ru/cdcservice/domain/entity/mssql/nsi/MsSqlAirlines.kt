package rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Proxy
import java.time.LocalDateTime
import javax.persistence.*

@Table(
    name = "COMPANY", indexes = [
        Index(name = "COMPANY_IK_R_DV", columnList = "IK_R, DV"),
        Index(name = "COMPANY_UG_DV", columnList = "UG, DV"),
        Index(name = "COMPANY_RCP_DV", columnList = "RCP, DV"),
        Index(name = "COMPANY_IK_DV", columnList = "IK, DV"),
        Index(name = "IX_COMPANY_do_DV_OK_UG_IATA_IK_nm_NM1_cc", columnList = "do, DV"),
        Index(name = "COMPANY_KC_DV", columnList = "KC, DV"),
        Index(name = "idx_company_do", columnList = "do, UG, IATA, IK, IK_R"),
        Index(name = "COMPANY_IATA_DV", columnList = "IATA, DV"),
        Index(name = "IX_COMPANY_idOK_DV", columnList = "id_OK, DV"),
        Index(name = "IX_COMPANY_missing_55937", columnList = "DV, do"),
        Index(name = "IX_COMPANY_OK_DV", columnList = "OK, DV")
    ]
)
@Entity
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
open class MsSqlAirlines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "id_OK", nullable = false)
    open var idOk: Int = 0

    @Column(name = "OK", nullable = false, length = 4)
    open var ok: String = "  "

    @Column(name = "UG", nullable = false, length = 2)
    open var ug: String = "  "

    @Column(name = "IATA", nullable = false, length = 2)
    open var iata: String = "  "

    @Column(name = "KC", nullable = false, length = 3)
    open var kc: String = "  "

    @Column(name = "IK", nullable = false, length = 3)
    open var ik: String = "  "

    @Column(name = "IK_R", nullable = false, length = 3)
    open var ikR: String = "  "

    @Column(name = "nm", nullable = false, length = 200)
    open var nm: String = "  "

    @Column(name = "NM1", nullable = false, length = 25)
    open var nm1: String = "  "

    @Column(name = "nl", nullable = false, length = 200)
    open var nl: String = "  "

    @Column(name = "NL1", nullable = false, length = 25)
    open var nl1: String = "  "

    @Column(name = "ID_CITY", nullable = false)
    open var idCity: Int = 0

    @Column(name = "cc", nullable = false, length = 2)
    open var cc: String = "  "

    @Column(name = "DV", nullable = false)
    open var dv: LocalDateTime = LocalDateTime.now()

    @Column(name = "do")
    open var dO: LocalDateTime? = null

    @Column(name = "ds", nullable = false)
    open var ds: LocalDateTime = LocalDateTime.now()

    @Column(name = "dk", nullable = false)
    open var dk: LocalDateTime = LocalDateTime.now()

    @Column(name = "REM", nullable = false, length = 300)
    open var rem: String = "  "

    @Column(name = "AFTN", nullable = false, length = 8)
    open var aftn: String = "  "

    @Column(name = "SITA", nullable = false, length = 7)
    open var sita: String = "  "

    @Column(name = "TEL", nullable = false, length = 15)
    open var tel: String = "  "

    @Column(name = "FAX", nullable = false, length = 15)
    open var fax: String = "  "

    @Column(name = "ADR", nullable = false, length = 100)
    open var adr: String = "  "

    @Column(name = "RCP", nullable = false, length = 3)
    open var rcp: String = "  "

    @Column(name = "Name_TKP", nullable = false, length = 24)
    open var nameTkp: String = "  "

    @Column(name = "cop", nullable = false)
    open var cop: Int = 0

    @Column(name = "FakeIATA")
    open var fakeIATA: Boolean? = null
}