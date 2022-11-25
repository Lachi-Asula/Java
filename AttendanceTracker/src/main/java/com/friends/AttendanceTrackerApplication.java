package com.friends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AttendanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceTrackerApplication.class, args);
		System.out.println("Welcome to Attendance Tracker application");
	}

}
