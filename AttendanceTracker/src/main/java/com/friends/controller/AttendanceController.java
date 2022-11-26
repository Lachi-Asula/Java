package com.friends.controller;


import com.friends.dto.GetEmpInfo_BasedOn_BatchNum;
import com.friends.dto.Login_Res_Dto;
import com.friends.service.GetBatch_Info;
import com.friends.service.GetEmpRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/attendanceTracking/friends/attendance")
public class AttendanceController {

    @Autowired
    private GetEmpRole getEmpRole;

    @Autowired
    private GetBatch_Info batchInfo;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Attendance Tracking Application";
    }

    @GetMapping("/getAllBatches")
    public ResponseEntity<Login_Res_Dto> getAllBatchesInfo(){
        return ResponseEntity.ok(getEmpRole.getAllbatches());
    }

    @GetMapping("/getEmployeeList")
    public ResponseEntity<GetEmpInfo_BasedOn_BatchNum> getEmployeeInfoBasedOnBatch(@RequestParam("BatchNumber") String batchNum){
        return ResponseEntity.ok(batchInfo.getEmpInfoBasedOnBatchNum(batchNum));
    }
}
