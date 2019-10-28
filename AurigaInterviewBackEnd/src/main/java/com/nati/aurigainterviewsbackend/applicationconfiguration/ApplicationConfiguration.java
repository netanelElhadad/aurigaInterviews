package com.nati.aurigainterviewsbackend.applicationconfiguration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
// we scanning all the folder under that path
@ComponentScan("com.nati.aurigainterviewsbackend")
// get access to application.properties
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

	// we injecting 'database.driver' value from 'application.properties' to that variable.
	@Value("${database.driver}")
	private String databaseDriverClass;
	
	@Value("${database.url}")
	private String databaseUrl;

	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(databaseDriverClass);
		dataSource.setUrl(databaseUrl);
		
		System.out.println("Datasource defined at URL: " + databaseUrl + " with driver: " + databaseDriverClass);
		
		return dataSource;
	}
	
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(datasource());
		return jdbcTemplate;
	}
	
}
