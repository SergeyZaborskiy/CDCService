package rivcpulkovo.ru.cdcservice.domain.entity.mssql

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Proxy
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "COUNTRY")
@Entity
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
open class MsSqlCountry {
    @Id
    @Column(name = "cc", nullable = false, length = 2)
    open var id: String? = null

    @Column(name = "cc_v", nullable = false, length = 2)
    open var ccV: String? = null

    @Column(name = "kc", nullable = false, length = 3)
    open var kc: String? = null

    @Column(name = "nm", nullable = false, length = 25)
    open var nm: String? = null

    @Column(name = "nl", nullable = false, length = 25)
    open var nl: String? = null

    @Column(name = "ap_c", nullable = false, length = 3)
    open var apC: String? = null

    @Column(name = "rg", nullable = false, length = 15)
    open var rg: String? = null

    @Column(name = "kk", nullable = false, length = 2)
    open var kk: String? = null

    @Column(name = "gr", nullable = false)
    open var gr: Char? = null

    @Column(name = "krg", nullable = false)
    open var krg: Char? = null

    @Column(name = "aci")
    open var aci: Char? = null

    @Column(name = "dk", nullable = false)
    open var dk: Instant? = null

    @Column(name = "cop", nullable = false)
    open var cop: Int? = null

    @Column(name = "alpha3", length = 3)
    open var alpha3: String? = null
}