package rivcpulkovo.ru.cdcservice.domain.entity.mssql.rds


import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "FlightPeriods", schema = "SCHED", catalog = "RDS")
open class MsSqlFlightPeriodsEntity {

    @Id
    @Column(name = "id")
    open var id: Int = 0

    @Column(name = "Fl_Performed", nullable = false)
    open var flPerformed: Boolean = false

    @Column(name = "BlockTimeType", nullable = false)
    open var blockTimeType: Int = 0

    @Column(name = "EndPeriod", nullable = false)
    open var endPeriod: LocalDateTime = LocalDateTime.now()

    @Column(name = "OwnerID", nullable = false)
    open var ownerID: Int = 0

    @Column(name = "DepSlotSCR_ID", nullable = false)
    open var depSlotSCRID: Int = 0

    @Column(name = "DateOfChange", nullable = false)
    open var dateOfChange: LocalDateTime = LocalDateTime.now()

    @Column(name = "RSP", nullable = false)
    open var RSP: Int = 0

    @Column(name = "ID_Time_Ref", nullable = true)
    open var IDTimeRef: Int = 0

    @Column(name = "IDLayout", nullable = true)
    open var IDLayout: Int = 0

    @Column(name = "AircraftType", nullable = false)
    open var aircraftType: String = "  "

    @Column(name = "FlightTime", nullable = false)
    open var flightTime: LocalDateTime = LocalDateTime.now()

    @Column(name = "TerminalArr", nullable = true)
    open var terminalArr: String = "  "

    @Column(name = "IDAirportArr", nullable = false)
    open var IDAirportArr: Int = 0

    @Column(name = "DepTime", nullable = false)
    open var depTime: LocalDateTime = LocalDateTime.now()

    @Column(name = "TerminalDep", nullable = true)
    open var terminalDep: String = "  "

    @Column(name = "IDAirportDep", nullable = false)
    open var IDAirportDep: Int = 0

    @Column(name = "Deleted", nullable = false)
    open var deleted: Int = 0

    @Column(name = "DepSlotSCR_Time", nullable = false)
    open var depSlotSCRTime: LocalDateTime = LocalDateTime.now()

    @Column(name = "ArrSlotSCR_Time", nullable = false)
    open var arrSlotSCRTime: LocalDateTime = LocalDateTime.now()

    @Column(name = "ArrSlotSCR_ID", nullable = false)
    open var arrSlotSCRID: Int = 0

    @Column(name = "ArrSlot", nullable = false)
    open var arrSlot: Int = 0

    @Column(name = "COP", nullable = false)
    open var COP: Int = 0

    @Column(name = "SSM", nullable = false)
    open var SSM: Int = 0

    @Column(name = "DepSlot", nullable = false)
    open var depSlot: Int = 0

    @Column(name = "BlockTimeBasis", nullable = false)
    open var blockTimeBasis: Int = 0

    @Column(name = "IDTypeFlight", nullable = false)
    open var IDTypeFlight: Int = 0

    @Column(name = "ArrTime", nullable = false)
    open var arrTime: LocalDateTime = LocalDateTime.now()

    @Column(name = "WeekDays", nullable = false)
    open var weekDays: Int = 0

    @Column(name = "BeginPeriod", nullable = false)
    open var beginPeriod: LocalDateTime = LocalDateTime.now()

    @Column(name = "FlightNumber", nullable = false)
    open var flightNumber: String = "  "

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42
}

