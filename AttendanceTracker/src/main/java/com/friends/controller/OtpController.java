package com.friends.controller;

import com.friends.dao.OTP_Info_Dao;
import com.friends.dto.CommonResponse;
import com.friends.dto.EmpStaffInfo;
import com.friends.dto.OTPDto;
import com.friends.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendanceTracking/friends/password/")
public class OtpController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private OTP_Info_Dao otpInfoDao;

    @Autowired
    OTPService otpService;

    @GetMapping("/getEmpStaffInfo")
    public ResponseEntity<EmpStaffInfo> getEmpOrStaffInfo(@RequestParam("EmpStaffId") String empStaffId){
        return ResponseEntity.ok(otpService.getEmpStaffInfoFromDb(empStaffId));
    }

    @PostMapping("/forgotPassword")
    private ResponseEntity<CommonResponse> forgotPassword(@RequestBody OTPDto otpDto){
        return ResponseEntity.ok(otpService.forgotPassword(otpDto));
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<CommonResponse> verifyOTPOnMobile(@RequestBody OTPDto otpDto){
        return ResponseEntity.ok(otpService.verifyOtp(otpDto));
    }

    @PostMapping("/updatePassword")
    private ResponseEntity<CommonResponse> updatePassword(@RequestBody OTPDto otpDto){
        return ResponseEntity.ok(otpService.updatePassword(otpDto));
    }

}
