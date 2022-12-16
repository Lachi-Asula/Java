package com.friends.controller;


import com.friends.dto.Attendance_Batch_Dto;
import com.friends.dto.CommonResponse;
import com.friends.dto.GetEmpInfo_BasedOn_BatchNum;
import com.friends.dto.Login_Res_Dto;
import com.friends.service.Attendance_Batch;
import com.friends.service.GetBatch_Info;
import com.friends.service.GetEmpRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/attendanceTracking/friends/attendance")
public class AttendanceController {

    @Autowired
    private GetEmpRole getEmpRole;

    @Autowired
    private GetBatch_Info batchInfo;

    @Autowired
    private Attendance_Batch attendanceBatch;

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

    @PostMapping("/saveEmployeeInfo")
    public ResponseEntity<CommonResponse> saveEmployeeInfo(@RequestBody List<Attendance_Batch_Dto> attendanceBatchDto){
        return ResponseEntity.ok(attendanceBatch.saveAttendance(attendanceBatchDto));
    }
}
