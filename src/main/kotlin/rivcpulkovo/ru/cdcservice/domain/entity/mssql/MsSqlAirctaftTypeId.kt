package rivcpulkovo.ru.cdcservice.domain.entity.mssql

import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class MsSqlAirctaftTypeId : Serializable {
    @Column(name = "TS", nullable = false, length = 3)
    open var ts: String? = null

    @Column(name = "MD", nullable = false)
    open var md: Char? = null

    override fun hashCode(): Int = Objects.hash(ts, md)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as MsSqlAirctaftTypeId

        return ts == other.ts &&
                md == other.md
    }

    companion object {
        private const val serialVersionUID = 8144655793983767156L
    }
}