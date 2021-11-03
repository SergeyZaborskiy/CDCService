package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime
import javax.persistence.*

@JsonIgnoreProperties("hibernateLazyInitializer")
@Table(name = "time_zone_names")
@Entity
open class TimeZoneName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "name", nullable = false, length = 150)
    open var name: String = "нд"

/*    @Column(name = "country_id", nullable = false)
    open var countryId: Int = 0*/

    @ManyToOne(optional = false) //fetch = FetchType.LAZY,
    @JoinColumn(name = "country_id") //, nullable = false, insertable = false, updatable =false
    open var country: Country? = null

    @Column(name = "code", nullable = false, length = 3)
    open var code: String = "нд"

    @Column(name = "creation_date")
    open var creationDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime? = null

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int = 0

    public constructor(timeZone: TimeZone, countryId: Int, countryCode: String) {
        this.name = countryCode
        this.code = timeZone.code
        this.country?.id = countryId
    }
}