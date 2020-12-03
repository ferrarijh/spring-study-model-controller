package com.jonathan.practice.datasource

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PostgresDatasource {

    @Bean
    @ConfigurationProperties("app.datasource")  //refer to yml
    fun hikariDataSource(): HikariDataSource{       //Hikari: solid high-performance JDBC connection pool
        return DataSourceBuilder.create()
                .type(HikariDataSource::class.java)
                .build()
    }
}