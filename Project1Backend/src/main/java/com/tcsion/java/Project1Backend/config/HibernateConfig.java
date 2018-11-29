package com.tcsion.java.Project1Backend.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.tcsion.java.Project1Backend"})
@EnableTransactionManagement
public class HibernateConfig {
	BasicDataSource dataSource;
	// Change the below final variable value based on database you choose

	private final static String DATABASE_URL = "jdbc:h2:~/test";     //for creating new database we change the value of url
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECTS = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "sa";

	// Database will be available
	@Bean("dataSource")
	public DataSource getSource() {
		dataSource = new BasicDataSource();
		// Providing database connection Information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);

		return dataSource;
	}

	// Database will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.tcsion.java.Project1Backend.dto");
		return builder.buildSessionFactory();
	}

	// For Hibernate property return
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECTS);
		properties.put("hibernate.show_sql", "true"); // to see the queries on console
		properties.put("hibernate.format_sql", "true"); // to formate the queries 
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

	// HibernateTransactionManager
	@Bean
	public HibernateTransactionManager getTransactionManagement(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}


