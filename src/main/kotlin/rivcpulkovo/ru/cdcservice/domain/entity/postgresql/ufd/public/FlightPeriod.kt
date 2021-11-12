package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.ufd.public

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.rds.MsSqlFlightPeriodsEntity
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.AircraftType
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airline
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.ComplianceCode
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Table(name = "flight_periods")
@Entity
open class FlightPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //готово
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "num_flight", nullable = false, length = 10) //готово
    open var numFlight: String = "  "

    @Column(name = "is_cancelled", nullable = false) //готово
    open var isCancelled: Boolean = false

    @Column(name = "begin_period", nullable = false) //готово
    open var beginPeriod: LocalDateTime = LocalDateTime.now()

    @Column(name = "end_period", nullable = false) //готово
    open var endPeriod: LocalDateTime = LocalDateTime.now()

    @Column(name = "frequency", nullable = false) //готово
    open var frequency: Int = 0

    @Column(name = "id_ap_dep", nullable = false) //Изменить на Airport по прилету
    open var idAirportDeparture: Int = 0

/*    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ap_dep", nullable = false)
    open var airportDeparture: Airport? = null*/

    @Column(name = "terminal_dep", length = 2) //готово
    open var terminalDeparture: String = "  "

    @Column(name = "id_ap_arr", nullable = false) //Изменить на Airport по вылету
    open var idAirportArrival: Int = 0

/*    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ap_arr", nullable = false)
    open var airportArrival: Airport? = null*/

    @Column(name = "terminal_arr", length = 2) //готово
    open var terminalArrival: String = "  "

    @Column(name = "id_aircraft_type", nullable = false) //Изменить на AircraftType
    open var idAircraftType: Int = 0

/*
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_aircraft_type", nullable = false)
    open var aircraftType: AircraftType? = null
*/

    @Column(name = "seat_f", nullable = false) //пока не понял
    open var seatF: Int = 0

    @Column(name = "seat_c", nullable = false) //пока не понял
    open var seatC: Int = 0

    @Column(name = "seat_y", nullable = false) //пока не понял
    open var seatY: Int = 0

    @Column(name = "id_type_flight", nullable = false) //Изменить на ComplianceCode
    open var idTypeFlight: Int = 0

/*    @ManyToOne(optional = false)
    @JoinColumn(name = "id_type_flight", nullable = false)
    open var complianceCode: ComplianceCode? = null*/

    @Column(name = "flight_time", nullable = false) //готово
    open var flightTime: Int = 0

    @Column(name = "time_dep", nullable = false) //готово
    open var timeDep: LocalDateTime = LocalDateTime.now()

    @Column(name = "time_arr", nullable = false) //готово
    open var timeArr: LocalDateTime = LocalDateTime.now()

    @Column(name = "id_ac", nullable = false) //Изменить на Airline
    open var idAirline: Int = 0

/*    @ManyToOne(optional = false)
    @JoinColumn(name = "id_ac", nullable = false)
    open var airline: Airline? = null*/

    @Column(name = "code_ac", length = 2) //Изменить на Airline.name
    open var codeAc: String = "FV"


    @Column(name = "creation_date", nullable = false) //готово
    open var creationDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "correction_date") //готово
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int = 0

    constructor(
        msFlightPeriod: MsSqlFlightPeriodsEntity,
        idAirportDeparture: Int,
        idAirportArrival: Int,
        idAircraftType: Int,
        idTypeFlight: Int,
        idAirline: Int
    ) {
        this.numFlight = msFlightPeriod.flightNumber
        this.isCancelled = if (msFlightPeriod.deleted == 1) true else false
        this.beginPeriod = msFlightPeriod.beginPeriod
        this.endPeriod = msFlightPeriod.endPeriod
        this.frequency = msFlightPeriod.weekDays
        this.terminalDeparture = msFlightPeriod.terminalDep
        this.terminalArrival = msFlightPeriod.terminalArr
        this.flightTime = msFlightPeriod.flightTime.toEpochSecond(ZoneOffset.UTC).toInt()
        this.timeDep = msFlightPeriod.depTime
        this.timeArr = msFlightPeriod.arrTime
        this.idAirportDeparture = idAirportDeparture
        this.idAirportArrival = idAirportArrival
        this.idAircraftType = idAircraftType
        this.idTypeFlight = idTypeFlight
        this.idAirline = idAirline

    }
}

