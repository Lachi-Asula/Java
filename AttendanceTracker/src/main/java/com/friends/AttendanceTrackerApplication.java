package com.friends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AttendanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceTrackerApplication.class, args);
	//	System.out.println("Welcome to Attendance Tracker application");
	}

}
