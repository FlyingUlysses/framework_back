package com.siniswift.syncComputerInfo;

import org.hyperic.sigar.SigarException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SyncComputerInfoApplication {

	public static void main(String[] args) throws SigarException {
		SpringApplication.run(SyncComputerInfoApplication.class, args);
	}
}
