package com.friends.controller;

import com.friends.dto.CommonResponse;
import com.friends.dto.EmailDto;
import com.friends.dto.SMSDto;
import com.friends.service.SendEmail;
import com.friends.service.SendSMS;
import com.friends.service.impl.SendSMS_Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/attendanceTracking/friends/email")
public class EmailController {

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private SendSMS sendSMS;

    @PostMapping("/sendOtpOnEmail")
    private ResponseEntity<CommonResponse> sendOtpOnEmail(@RequestBody EmailDto emailDto){
        return ResponseEntity.ok(sendEmail.sendOtpOnEmail(emailDto));
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<CommonResponse> verifyOTPOnMobile(@RequestBody SMSDto smsDto){
        return ResponseEntity.ok(sendSMS.verifyOtp(smsDto));
    }
}
