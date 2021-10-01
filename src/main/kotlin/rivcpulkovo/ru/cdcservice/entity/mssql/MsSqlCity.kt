package rivcpulkovo.ru.cdcservice.entity.mssql

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "CITY_N")
@Entity
open class MsSqlCity {
    @Id
    @Column(name = "ID_CITY", nullable = false)
    open var id: Int? = null
}