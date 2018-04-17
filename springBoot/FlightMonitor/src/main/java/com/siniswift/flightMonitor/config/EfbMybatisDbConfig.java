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
@MapperScan( basePackages = {"com.siniswift.flightMonitor.dao.flight"},sqlSessionFactoryRef = "efbSqlSessionFactory")
public class EfbMybatisDbConfig {
	
	@Autowired
	@Qualifier("efbDs")
	private DataSource efb;
	
	@Bean
	public SqlSessionFactory efbSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(efb);
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate efbSqlSessionTemplate() throws Exception {
		return  new SqlSessionTemplate(efbSqlSessionFactory());
	}
	
}
