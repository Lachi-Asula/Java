package com.friends.controller;

import com.friends.dto.CommonResponse;
import com.friends.dto.UpdateStatusDto;
import com.friends.service.UpdateStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendanceTracking/friends/employee")
public class UpdateStatus_Controller {

    @Autowired
    private UpdateStatus updateStatus;

    @PostMapping("/updateStatus")
    private ResponseEntity<CommonResponse> updateStatusByEmpId(@RequestBody UpdateStatusDto updateStatusDto){
        return ResponseEntity.ok(updateStatus.updateStatusOfEmp(updateStatusDto));
    }
}
