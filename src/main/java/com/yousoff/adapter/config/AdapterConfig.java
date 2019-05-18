package com.yousoff.adapter.config;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.github.mfpdev.adapters.spring.integration.SpringBaseApplication;
import com.yousoff.	spring.config.SpringConfig;

@Configuration
@Import({SpringConfig.class})
@ComponentScan({"com.yousoff.adapter.config", "com.yousoff.adapter.controller"})
public class AdapterConfig extends SpringBaseApplication {

	private static final String IS_MFP_JDBC = "Y";
	private static final String JDBC_MYSQL = "jdbc/mysql";
	private InitialContext context;
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource restDataSource() {
		System.out.println("[AdapterConfig] loading datasource...");
		
		if("N".equals(IS_MFP_JDBC)) {
			// use jdbc connection from code
			System.out.println("[AdapterConfig] loading from code...");
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
			dataSource.setUrl(env.getProperty("jdbc.url"));
			dataSource.setUsername(env.getProperty("jdbc.user"));
			dataSource.setPassword(env.getProperty("jdbc.pass"));
			return dataSource;
		
		} else {
			// use jdbc connection from mfp server.xml
			System.out.println("[AdapterConfig] loading from server.xml...");
			try {
				if(context == null ) context = new InitialContext();
				DataSource dataSource = (DataSource) context.lookup(JDBC_MYSQL);
				return dataSource;
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
