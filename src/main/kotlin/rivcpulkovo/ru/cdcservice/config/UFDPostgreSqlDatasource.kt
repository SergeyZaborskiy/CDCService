package rivcpulkovo.ru.cdcservice.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.AircraftType
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airline
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.Airport
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.nsi.public_schema.ComplianceCode
import rivcpulkovo.ru.cdcservice.domain.entity.postgresql.ufd.public.FlightPeriod
import javax.persistence.EntityManagerFactory


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["rivcpulkovo.ru.cdcservice.domain.repository.postgresql.ufd"],
    entityManagerFactoryRef = "ufdPgEntityManager", transactionManagerRef = "ufdPgTransactionManager"
)
class UFDPostgreSqlDatasource {

    @Bean
    @ConfigurationProperties(prefix = "postgreufd.spring.datasource")
    fun ufdPgHikariDataSource(): HikariDataSource {
        return DataSourceBuilder
            .create()
            .type(HikariDataSource::class.java)
            .build()
    }


    @Bean(name = ["ufdPgEntityManager"])
    fun ufdPgEntityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {

        val hibernateProps: Map<String, String> = mapOf(
            "hibernate.dialect" to "org.hibernate.dialect.PostgreSQL82Dialect",
            "hibernate.ddl-auto" to "none"
        )


        return builder
            .dataSource(ufdPgHikariDataSource())
            .properties(hibernateProps)
            .packages(FlightPeriod::class.java)
            .persistenceUnit("ufdPgPU")
            .build()
    }

    @Bean(name = ["ufdPgTransactionManager"])
    fun ufdPgTransactionManager(@Qualifier("ufdPgEntityManager") entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}