package rivcpulkovo.ru.cdcservice.domain.entity.mssql

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Proxy
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "CITY_N")
@Entity
@JsonIgnoreProperties(ignoreUnknown = false)
@Proxy(lazy = false)
open class MsSqlCity {
    @Id
    @Column(name = "ID_CITY", nullable = false)
    open var id: Int? = null

    @Column(name = "ap_c", nullable = false, length = 3)
    open var apC: String? = null

    @Column(name = "iata", nullable = false, length = 3)
    open var iata: String? = null

    @Column(name = "ap_n", nullable = false, length = 3)
    open var apN: String? = null

    @Column(name = "name_c8", nullable = false, length = 8)
    open var nameC8: String? = null

    @Column(name = "name_ap", nullable = false, length = 25)
    open var nameAp: String? = null

    @Column(name = "NL", nullable = false, length = 25)
    open var nl: String? = null

    @Column(name = "st", nullable = false, length = 2)
    open var st: String? = null

    @Column(name = "cc", nullable = false, length = 2)
    open var cc: String? = null

    @Column(name = "TZ", nullable = false, length = 2)
    open var tz: String? = null

    @Column(name = "RU", nullable = false, length = 3)
    open var ru: String? = null

    @Column(name = "ds", nullable = false)
    open var ds: LocalDateTime? = null

    @Column(name = "dk", nullable = false)
    open var dk: LocalDateTime? = null

    @Column(name = "fil", nullable = false)
    open var fil: Char? = null

    @Column(name = "REM", nullable = false, length = 50)
    open var rem: String? = null

    @Column(name = "cop", nullable = false)
    open var cop: Int? = null
}