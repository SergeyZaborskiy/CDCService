package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.MsSqlAirport
import java.math.BigDecimal
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "airports")
@Entity
open class Airport() {
    @Column(name = "id", nullable = false)
    @Id
    open var id: Int? = null

    @Column(name = "country_id", nullable = false)
    open var countryId: Int? = null

    @Column(name = "city_id", nullable = false)
    open var cityId: Int? = null

    @Column(name = "inner_id", nullable = false)
    open var innerId: Int? = null

    @Column(name = "iata", nullable = false, length = 3)
    open var iata: String? = null

    @Column(name = "native", nullable = false, length = 3)
    open var _native: String? = null

    @Column(name = "icao", nullable = false, length = 4)
    open var icao: String? = null

    @Column(name = "native_icao", nullable = false, length = 4)
    open var nativeIcao: String? = null

    @Column(name = "military", nullable = false, length = 4)
    open var military: String? = null

    @Column(name = "native_military", nullable = false, length = 4)
    open var nativeMilitary: String? = null

    @Column(name = "short_name", nullable = false, length = 10)
    open var shortName: String? = null

    @Column(name = "full_name", nullable = false, length = 1000)
    open var fullName: String? = null

    @Column(name = "latitude", nullable = false, precision = 131089)
    open var latitude: BigDecimal? = null

    @Column(name = "longitude", nullable = false, precision = 131089)
    open var longitude: BigDecimal? = null

    @Column(name = "start_date", nullable = false)
    open var startDate: Instant? = null

    @Column(name = "end_date", nullable = false)
    open var endDate: Instant? = null

    @Column(name = "creation_date", nullable = false)
    open var creationDate: Instant? = null

    @Column(name = "correction_date")
    open var correctionDate: Instant? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int? = null

    @Column(name = "time_zone_inner_id", nullable = false)
    open var timeZoneInnerId: Int? = null

    constructor(data: MsSqlAirport) : this() {
        this.countryId
        this.cityId = data.idCity?.id
        this.countryId = 22
        this.innerId = data.id
        this.iata = data.iata
        this._native = data.ap
        this.icao = data.ik
        this.nativeIcao = data.ikR
        this.military = data.milm
        this.nativeMilitary = data.mil
        this.shortName = data.name8
        this.fullName = data.nameAp
        this.latitude = coordinatesToBigDecimal(data.lat)
        this.longitude = coordinatesToBigDecimal(data._long)
        this.startDate = data.ds
        this.endDate = null
        this.timeZoneInnerId = data.tz?.toIntOrNull()
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