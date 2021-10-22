package rivcpulkovo.ru.cdcservice.domain.entity.mssql

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "CITY")
@Entity
open class MsSqlCityOld {
    @Id
    @Column(name = "ap_c", nullable = false, length = 3)
    open var id: String = "нд"

    @Column(name = "ap_n", nullable = false, length = 3)
    open var apN: String = "нд"

    @Column(name = "name_ap", nullable = false, length = 25)
    open var nameAp: String = "нд"

    @Column(name = "NL", nullable = false, length = 25)
    open var nl: String = "нд"

    @Column(name = "ST", nullable = false, length = 2)
    open var st: String = "нд"

    @Column(name = "cc", nullable = false, length = 2)
    open var cc: String = "нд"

    @Column(name = "TZ", nullable = false, length = 2)
    open var tz: String = "нд"

    @Column(name = "dk", nullable = false)
    open var dk: LocalDateTime = LocalDateTime.now()
}