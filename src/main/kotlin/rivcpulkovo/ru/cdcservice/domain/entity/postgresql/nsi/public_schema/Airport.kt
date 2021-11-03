package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlAirport
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "airports", schema = "public", catalog = "nsi")
open class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

/*    @Column(name = "country_id", nullable = false)
    open var countryId: Int = 0*/

    @ManyToOne(optional = false) //fetch = FetchType.LAZY,
    @JoinColumn(name = "country_id") //, nullable = false, insertable = false, updatable =false
    open var country: Country? = null

    @ManyToOne(optional = false) //fetch = FetchType.LAZY,
    @JoinColumn(name = "city_id") //, nullable = false, insertable = false, updatable =false
    open var city: City? = null

/*    @Column(name = "city_id")
    open var cityId: Int = 0*/

    @ManyToOne(optional = false) //fetch = FetchType.LAZY,
    @JoinColumn(name = "time_zone_inner_id") //, nullable = false, insertable = false, updatable =false
    open var timeZoneName: TimeZoneName? = null

/*    @Column(name = "time_zone_inner_id")
    open var timeZoneNameId: Int = 0*/

    @Column(name = "inner_id", nullable = false)
    open var innerId: Int = 0

    @Column(name = "iata", nullable = false, length = 3)
    open var iata: String = "нд"

    @Column(name = "native", nullable = false, length = 3)
    open var native: String = "нд"

    @Column(name = "icao", nullable = false, length = 4)
    open var icao: String = "нд"

    @Column(name = "native_icao", nullable = false, length = 4)
    open var nativeIcao: String = "нд"

    @Column(name = "military", nullable = false, length = 4)
    open var military: String = "нд"

    @Column(name = "native_military", nullable = false, length = 4)
    open var nativeMilitary: String = "нд"

    @Column(name = "short_name", nullable = false, length = 10)
    open var shortName: String = "нд"

    @Column(name = "full_name", nullable = false, length = 1000)
    open var fullName: String = "нд"

    @Column(name = "latitude", nullable = false, precision = 131089)
    open var latitude: BigDecimal? = null

    @Column(name = "longitude", nullable = false, precision = 131089)
    open var longitude: BigDecimal? = null

    @Column(name = "start_date", nullable = false)
    open var startDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "end_date", nullable = false)
    open var endDate: LocalDateTime = LocalDateTime.now().plusYears(20)

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int = 0


    constructor(data: MsSqlAirport) {
        this.innerId = data.id ?: 0
        this.iata = data.iata ?: "нд"
        this.native = data.ap ?: "нд"
        this.icao = data.ik ?: "нд"
        this.nativeIcao = data.ikR ?: "нд"
        this.military = data.milm ?: "нд"
        this.nativeMilitary = data.mil ?: "нд"
        this.shortName = data.name8 ?: "нд"
        this.fullName = data.nameAp ?: "нд"
        this.latitude = coordinatesToBigDecimal(data.lat) ?: 0.0.toBigDecimal()
        this.longitude = coordinatesToBigDecimal(data._long) ?: 0.0.toBigDecimal()
        this.startDate = data.ds ?: LocalDateTime.now()
        this.endDate = LocalDateTime.now().plusYears(20)
        this.creationDate = LocalDateTime.now()
        this.editorId = 0
    }

    private fun coordinatesToBigDecimal(coordinate: String?): BigDecimal? {
        val direction: String? = coordinate?.substring(0, 1)
        var directionInt = 1
        var hours: Int?
        var minutes: Double?
        if (direction == "S" || direction == "W") {
            directionInt = -1
        }
        if (direction == "W" || direction == "E") {
            hours = coordinate?.substring(1, 4)?.toInt()
            minutes = (coordinate?.substring(4)?.toDouble())?.div(60)
        } else {
            hours = coordinate?.substring(1, 3)?.toInt()
            minutes = (coordinate?.substring(3)?.toDouble())?.div(60)
        }
        return (hours?.plus(minutes!!))?.times(directionInt)?.toBigDecimal()
    }
}