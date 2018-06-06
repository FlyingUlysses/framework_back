package com.siniswift.flightMonitor.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan( basePackages = {"com.siniswift.flightMonitor.dao"},sqlSessionFactoryRef = "monitorSqlSessionFactory")
public class MonitorMybatisDbConfig {
	
	@Autowired
	@Qualifier("monitorDs")
	private DataSource monitor;
	
	@Bean
	public SqlSessionFactory monitorSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(monitor);
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate monitorSqlSessionTemplate() throws Exception {
		return  new SqlSessionTemplate(monitorSqlSessionFactory());
	}
	
}
