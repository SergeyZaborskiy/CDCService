package rivcpulkovo.ru.cdcservice.entity.mssql

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "COUNTRY")
@Entity
open class MsSqlCountry {
    @Id
    @Column(name = "cc", nullable = false, length = 2)
    open var id: String? = null
}