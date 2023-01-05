package com.education.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educational/friends/")
public class WelcomeController {

    @GetMapping("welcome")
    public ResponseEntity<String> showWelcomeMsg(){
        return ResponseEntity.ok("Welcome to the Educational Tracker Application");
    }
}
