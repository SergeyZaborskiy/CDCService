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
import rivcpulkovo.ru.cdcservice.domain.entity.mssql.rds.MsSqlFlightPeriodsEntity
import javax.persistence.EntityManagerFactory


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = ["rivcpulkovo.ru.cdcservice.domain.repository.mssql.rds"],
    entityManagerFactoryRef = "rdsMsEntityManager", transactionManagerRef = "rdsMsTransactionManager"
)
class RDSMsSqlDatasource {

    @Bean
    @ConfigurationProperties(prefix = "msrds.spring.datasource")
    fun rdsMsHikariDataSource(): HikariDataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean(name = ["rdsMsEntityManager"])
    fun rdsMsEntityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {

        val hibernateProps: Map<String, String> = mapOf(
            "hibernate.dialect" to "org.hibernate.dialect.SQLServerDialect",
            "hibernate.ddl-auto" to "none"
        )

        return builder
            .dataSource(rdsMsHikariDataSource())
            .properties(hibernateProps)
            .packages(MsSqlFlightPeriodsEntity::class.java)
            .persistenceUnit("rdsMsPU")
            .build()
    }

    @Bean(name = ["rdsMsTransactionManager"])
    @Primary
    fun rdsMsTransactionManager(@Qualifier("rdsMsEntityManager") entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}