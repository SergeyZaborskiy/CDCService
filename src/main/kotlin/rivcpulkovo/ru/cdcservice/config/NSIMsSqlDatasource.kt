package rivcpulkovo.ru.cdcservice.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import rivcpulkovo.ru.cdcservice.entity.mssql.*
import javax.persistence.EntityManagerFactory

@Configuration
@EnableTransactionManagement
class NSIMsSqlDatasource {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    fun mssqlDataSource(): HikariDataSource {
        return DataSourceBuilder.create().type(HikariDataSource::class.java).build()
    }

    @Bean(name = ["mssqlEntityManager"])
    fun mysqlEntityManagerFactory(builder: EntityManagerFactoryBuilder): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(mssqlDataSource())
            .packages(MsSqlAirport::class.java)
            .packages(MsSqlAirctaftType::class.java)
            .packages(MsSqlAirctaftTypeId::class.java)
            .packages(MsSqlAirlines::class.java)
            .packages(MsSqlAirport::class.java)
            .packages(MsSqlCity::class.java)
            .packages(MsSqlCountry::class.java)
            .packages(MsSqlTimezone::class.java)
            .persistenceUnit("mssqlPU")
            .build()
    }

    @Bean(name = ["mssqlTransactionManager"])
    fun mssqlTransactionManager(@Qualifier("mssqlEntityManager") entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }

}