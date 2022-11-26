package com.friends.controller;

import com.friends.dto.CommonResponse;
import com.friends.dto.Emp_Info_Dto;
import com.friends.service.Emp_Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendanceTracking/friends/register")
public class Emp_Register_Controller {

    @Autowired
    private Emp_Register empRegister;

    @PostMapping("/employee")
    public ResponseEntity<CommonResponse> registerEmployee(@RequestBody Emp_Info_Dto empInfoDto){

        return ResponseEntity.ok(empRegister.Emp_Registration(empInfoDto));
    }
}
