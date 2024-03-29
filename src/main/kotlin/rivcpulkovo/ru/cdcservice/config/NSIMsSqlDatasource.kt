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
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.nsi.*
import javax.persistence.EntityManagerFactory

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["rivcpulkovo.ru.cdcservice.domain.repository.mssql.nsi"],
    entityManagerFactoryRef = "nsiMsEntityManager", transactionManagerRef = "nsiMsTransactionManager"
)
class NSIMsSqlDatasource {

    @Bean
    @ConfigurationProperties(prefix = "msnsi.spring.datasource")
    fun nsiMsHikariDataSource(): HikariDataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean(name = ["nsiMsEntityManager"])
    fun nsiMsEntityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {

        val hibernateProps: Map<String, String> = mapOf(
            "hibernate.dialect" to "org.hibernate.dialect.SQLServerDialect",
            "hibernate.ddl-auto" to "none"
        )

        return builder
            .dataSource(nsiMsHikariDataSource())
            .properties(hibernateProps)
            .packages(MsSqlAirport::class.java)
            .packages(MsSqlAirctaftType::class.java)
            .packages(MsSqlAirctaftTypeId::class.java)
            .packages(MsSqlAirlines::class.java)
            .packages(MsSqlAirport::class.java)
            .packages(MsSqlCity::class.java)
            .packages(MsSqlCountry::class.java)
            .packages(MsSqlTimezone::class.java)
            .persistenceUnit("nsiMsPU")
            .build()
    }

    @Bean(name = ["nsiMsTransactionManager"])
    @Primary
    fun nsiMsTransactionManager(@Qualifier("nsiMsEntityManager") entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}
