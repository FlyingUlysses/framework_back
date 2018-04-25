package com.siniswift.flightMonitor;

import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName:  主程序入口   
 * @author: wangyong 
 * @date:   2018年4月11日
 * @Description:开启入口注解，取消内置自动识别数据源
 */
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class
})
@EnableScheduling
@EnableTransactionManagement
public class FlightMonitorApplication {
	
	public static void main(String[] args) throws SchedulerException {
		SpringApplication.run(FlightMonitorApplication.class, args);
	}
	
}
