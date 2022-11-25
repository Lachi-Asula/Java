package com.friends.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendanceTracking/friends/")
public class AttendanceController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Attendance Tracking Application";
    }

}
