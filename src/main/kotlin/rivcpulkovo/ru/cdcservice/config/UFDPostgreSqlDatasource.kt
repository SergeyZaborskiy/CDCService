package rivcpulkovo.ru.cdcservice.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.public_schema.*
import javax.persistence.EntityManagerFactory


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["rivcpulkovo.ru.cdcservice.domain.repository.postgresql"],
    entityManagerFactoryRef = "ufdEntityManager", transactionManagerRef = "ufdTransactionManager"
)
class UFDPostgreSqlDatasource() {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "ufd.spring.datasource")
    fun ufdHikariDataSource(): HikariDataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }


    @Bean(name = ["ufdEntityManager"])
    @Primary
    fun ufdEntityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {

        val hibernateProps: Map<String, String> = mapOf(
            "hibernate.dialect" to "org.hibernate.dialect.PostgreSQL82Dialect",
            "hibernate.ddl-auto" to "none"
        )


        return builder
            .dataSource(ufdHikariDataSource())
            .properties(hibernateProps)
            .packages(AircraftType::class.java)
            .packages(Airline::class.java)
            .packages(Airport::class.java)
            .packages(AlternateType::class.java)
            .packages(BookingClass::class.java)
            .packages(City::class.java)
            .packages(ComplianceCode::class.java)
            .packages(Country::class.java)
            .packages(DelayReason::class.java)
            .packages(EtopsType::class.java)
            .packages(Language::class.java)
            .packages(MessageType::class.java)
            .packages(NavCalcType::class.java)
            .packages(PortTaxiTime::class.java)
            .packages(RouteType::class.java)
            .packages(SsrType::class.java)
            .packages(TimeZone::class.java)
            .packages(WaypointType::class.java)
            .persistenceUnit("ufdPU")
            .build()
    }

    @Bean(name = ["ufdTransactionManager"])
    @Primary
    fun ufdTransactionManager(@Qualifier("ufdEntityManager") entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }

}