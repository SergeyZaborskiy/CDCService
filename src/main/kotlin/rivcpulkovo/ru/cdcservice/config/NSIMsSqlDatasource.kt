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
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.*
import javax.persistence.EntityManagerFactory

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["rivcpulkovo.ru.cdcservice.domain.repository.mssql"],
    entityManagerFactoryRef = "nsiEntityManager", transactionManagerRef = "nsiTransactionManager"
)
class NSIMsSqlDatasource {

    @Bean
    @ConfigurationProperties(prefix = "nsi.spring.datasource")
    fun nsiHikariDataSource(): HikariDataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean(name = ["nsiEntityManager"])
    fun mysqlEntityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {

        val hibernateProps: Map<String, String> = mapOf(
            "hibernate.dialect" to "org.hibernate.dialect.SQLServerDialect",
            "hibernate.ddl-auto" to "none"
        )

        return builder
            .dataSource(nsiHikariDataSource())
            .properties(hibernateProps)
            .packages(MsSqlAirport::class.java)
            .packages(MsSqlAirctaftType::class.java)
            .packages(MsSqlAirctaftTypeId::class.java)
            .packages(MsSqlAirlines::class.java)
            .packages(MsSqlAirport::class.java)
            .packages(MsSqlCity::class.java)
            .packages(MsSqlCountry::class.java)
            .packages(MsSqlTimezone::class.java)
            .persistenceUnit("nsiPU")
            .build()
    }

    @Bean(name = ["nsiTransactionManager"])
    @Primary
    fun mssqlTransactionManager(@Qualifier("nsiEntityManager") entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}
