package com.education.controller;

import com.education.dto.*;
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

    @PostMapping("/getStudentInfo")
    public ResponseEntity<StudentInfoResDto> getStudentInfo(@RequestBody UserIdReqDto userIdReqDto){
        return ResponseEntity.ok((studentRegistration.getStudentInfoBasedOnUserId(userIdReqDto)));
    }

    @GetMapping("/getAllStudentsInfo")
    public ResponseEntity<AllStudentsInfoBasedOnStandard_ResDto> getAllStudentsInfo(@RequestParam("Standard") String standard){
        return ResponseEntity.ok((studentRegistration.getAllStudentsBasedOnStandard(standard)));
    }
}
