package com.education.controller;

import com.education.dto.CommonResponseDto;
import com.education.dto.StaffRegistration_Dto;
import com.education.dto.StudentRegistration_Dto;
import com.education.service.StaffRegistration;
import com.education.service.StudentRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educational/friends/register")
public class Registration_Controller {

    @Autowired
    private StudentRegistration studentRegistration;

    @Autowired
    private StaffRegistration staffRegistration;

    @PostMapping("/student")
    public ResponseEntity<CommonResponseDto> registerStudent(@RequestBody StudentRegistration_Dto studentRegistrationDto){
        return ResponseEntity.ok(studentRegistration.registerStudent(studentRegistrationDto));
    }

    @PostMapping("/staff")
    public ResponseEntity<CommonResponseDto> registerStaff(@RequestBody StaffRegistration_Dto staffRegistrationDto){
        return ResponseEntity.ok(staffRegistration.registerStaff(staffRegistrationDto));
    }
}
