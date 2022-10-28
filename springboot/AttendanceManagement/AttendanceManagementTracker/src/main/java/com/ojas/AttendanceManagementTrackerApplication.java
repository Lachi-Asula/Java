package com.ojas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AttendanceManagementTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementTrackerApplication.class, args);
	}

}
