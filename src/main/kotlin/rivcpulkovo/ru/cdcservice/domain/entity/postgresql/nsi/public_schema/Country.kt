package rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.MsSqlCountry
import java.time.LocalDateTime
import javax.persistence.*

@JsonIgnoreProperties("hibernateLazyInitializer")
@Table(name = "countries")
@Entity
open class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "alpha2", nullable = false, length = 2)
    open var alpha2: String = "нд"

    @Column(name = "alpha3", nullable = false, length = 3)
    open var alpha3: String = "нд"

    @Column(name = "num_сс", nullable = false, length = 3)
    open var numСс: String = "нд"

    @Column(name = "name", nullable = false, length = 1000)
    open var name: String = "нд"

    @Column(name = "creation_date", nullable = false)
    open var creationDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "correction_date")
    open var correctionDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "editor_id", nullable = false)
    open var editorId: Int = 0

    @ManyToOne(optional = false) //fetch = FetchType.LAZY,
    @JoinColumn(name = "default_lang_id") //, nullable = false, insertable = false, updatable =false
    open var defaultLang: Language? = null

    constructor(data: MsSqlCountry) {
        this.alpha2 =data.id?: "нд"
        this.alpha3 = data.alpha3?: "нд"
        this.numСс = data.kc?: "нд"
        this.name = data.nm?: "нд"
        this.creationDate = LocalDateTime.now()
        this.correctionDate = data.dk?: LocalDateTime.now()
        this.editorId = 0
    }
}