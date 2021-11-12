package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirctaftType
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "aircraft_types")
@Entity
open class AircraftType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //done
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "iata", nullable = false, length = 3) //done
    open var iata: String? = null

    @Column(name = "native", nullable = false, length = 3) //done
    open var native: String? = null

    @Column(name = "icao", nullable = false, length = 4) //done
    open var icao: String? = null

    @Column(name = "native_icao", nullable = false, length = 4) //done
    open var nativeIcao: String? = null

    @Column(name = "num_code", nullable = false) //done
    open var numCode: Int? = null

    @Column(name = "short_name", nullable = false) //done
    open var shortName: String? = null

    @Column(name = "full_name", nullable = false) //done
    open var fullName: String? = null

    @Column(name = "seats", nullable = false) //done
    open var seats: Int? = null

    @Column(name = "is_helicopter", nullable = false) //done
    open var isHelicopter: Boolean? = false

    @Column(name = "dow", nullable = false) //done
    open var dow: Int? = null

    @Column(name = "law", nullable = false) //done
    open var law: Int? = null

    @Column(name = "mtow", nullable = false) //done
    open var mtow: Int? = null

    @Column(name = "creation_date", nullable = false) //done
    open var creationDate: LocalDateTime? = null

    @Column(name = "correction_date") //done
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false) //done
    open var editorId: Int? = null

    @Column(name = "md", nullable = false, length = 1) //done
    open var md: String? = null

    @Column(name = "native_md", nullable = false, length = 1) //done
    open var nativeMd: String? = null

    @Column(name = "description", nullable = false, length = 1000)
    open var description: String? = null

    constructor(msAircraftType: MsSqlAirctaftType) {
        this.iata = msAircraftType.tsM
        this.native = msAircraftType.ts
        this.icao = msAircraftType.ts4M
        this.nativeIcao = msAircraftType.ts4
        this.numCode = msAircraftType.name3?.toInt()
        this.shortName = msAircraftType.nameTyp
        this.fullName = msAircraftType.nameFull
        try {
            this.seats = msAircraftType.km?.trim()?.toInt()
        } catch (e: NumberFormatException) {
            this.seats = 0
        }
        this.isHelicopter = if (msAircraftType.catCode.toString().isNullOrBlank()) false else true
        this.dow = msAircraftType.ew?.toInt()
        this.law = msAircraftType.pw?.toInt()
        this.mtow = msAircraftType.mw?.toInt()
        this.creationDate = LocalDateTime.now()
        this.correctionDate = msAircraftType.dk
        this.md = msAircraftType.mdM.toString()
        this.nativeMd = msAircraftType.md
        this.editorId = msAircraftType.cop
        this.description = "  "
    }
}