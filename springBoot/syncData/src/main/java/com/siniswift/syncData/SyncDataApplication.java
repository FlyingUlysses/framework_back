package com.siniswift.syncData;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.siniswift.syncData.dao")
public class SyncDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyncDataApplication.class, args);
	}
}
