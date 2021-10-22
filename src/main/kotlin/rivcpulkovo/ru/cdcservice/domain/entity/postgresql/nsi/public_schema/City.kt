package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlCity
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "cities")
@Entity
open class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    open var country: Country? = null

    @Column(name = "country_id", nullable = false)
    open var countryId: Int = 0

    @Column(name = "inner_id", nullable = false)
    open var innerId: Int = 0

    @Column(name = "iata", nullable = false, length = 3)
    open var iata: String = "нд"

    @Column(name = "native", nullable = false, length = 3)
    open var native: String = "нд"

    @Column(name = "short_name", nullable = false, length = 100)
    open var shortName: String = "нд"

    @Column(name = "full_name", nullable = false, length = 1000)
    open var fullName: String = "нд"

    @Column(name = "start_date", nullable = false)
    open var startDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "end_date")
    open var endDate: LocalDateTime? = null

    @Column(name = "is_capital", nullable = false)
    open var isCapital: Boolean = false

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "time_zone_inner_id", nullable = false, insertable = false, updatable = false)
    open var timeZoneInner: Language? = null

    @Column(name = "time_zone_inner_id", nullable = false)
    open var timeZoneInnerId: Int = 0

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int = 0

    constructor(data: MsSqlCity, countryId: Int, timeZoneInnerId: Int, isCapital: Boolean) {
        this.countryId = countryId
        this.innerId = data.id ?: 0
        this.iata = data.iata?: "нд"
        this.native = data.apC?: "нд"
        this.shortName = data.nameC8?: "нд"
        this.fullName = data.nameAp?: "нд"
        this.startDate = LocalDateTime.now()
        this.isCapital = isCapital
        this.timeZoneInnerId = timeZoneInnerId
        this.creationDate = LocalDateTime.now()
        this.editorId = 0


    }
}