package com.stockquotemanager.data;

import javax.activation.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;

@Configuration
public class Dataconfiguration {
	
	@Bean 
	public  DataSource dataSource() {
		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://locahost:8080/eventosapp");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		return (DataSource) dataSource ;
		
	}
	
	
	
	@Bean 
	public  JpaVendorAdapter jpaVendedorAdapter() {
		HibernateJpaVendorAdapter  adapter = new HibernateJpaVendorAdapter ();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
		
	}

}


