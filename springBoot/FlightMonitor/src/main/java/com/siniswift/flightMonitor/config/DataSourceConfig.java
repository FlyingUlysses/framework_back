package com.siniswift.flightMonitor.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean(name = "efbDs")
	@ConfigurationProperties(prefix = "spring.datasource.efb")
	public DataSource efb() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name ="notamDs" )
	@ConfigurationProperties(prefix = "spring.datasource.notam")
	public DataSource natom(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name ="aipsDs" )
	@ConfigurationProperties(prefix = "spring.datasource.aips")
	public DataSource aips(){
		return DataSourceBuilder.create().build();
	}
	
}
