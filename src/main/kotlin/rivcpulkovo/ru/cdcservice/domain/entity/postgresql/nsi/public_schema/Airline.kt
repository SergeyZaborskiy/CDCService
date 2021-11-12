package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlAirlines
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "airlines")
@Entity
open class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    open var country: Country? = null

    @Column(name = "inner_id", nullable = false) //готово
    open var innerId: Int = 0

    @Column(name = "iata", nullable = false, length = 2) //готово
    open var iata: String = "  "

    @Column(name = "native", nullable = false, length = 2) //done
    open var native: String = "  "

    @Column(name = "icao", nullable = false, length = 3) //done
    open var icao: String = "  "

    @Column(name = "num_al", nullable = false, length = 3) //done
    open var numAl: String = "  "

    @Column(name = "native_icao", nullable = false, length = 3) //done
    open var nativeIcao: String = "  "

    @Column(name = "short_name", nullable = false) //done
    open var shortName: String = "  "

    @Column(name = "full_name", nullable = false, length = 500) //done
    open var fullName: String = "  "

    @Column(name = "start_date", nullable = false) //done
    open var startDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "end_date", nullable = false) //done
    open var endDate: LocalDateTime = LocalDateTime.now().plusYears(40)

    @Column(name = "creation_date", nullable = false) //done
    open var creationDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "correction_date") //done
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false) //done
    open var editorId: Int = 0

    constructor(msAirline: MsSqlAirlines) {
        this.innerId = msAirline.id
        this.iata = msAirline.iata
        this.native = msAirline.ug
        this.icao = msAirline.ik
        this.numAl = msAirline.kc
        this.nativeIcao = msAirline.ikR
        this.shortName = msAirline.nm1
        this.fullName = msAirline.nm
        this.startDate = msAirline.dv
        this.endDate = msAirline.dO?: LocalDateTime.now().plusYears(40)
        this.creationDate = msAirline.ds
        this.correctionDate = msAirline.dk
        this.editorId = msAirline.cop
    }
}