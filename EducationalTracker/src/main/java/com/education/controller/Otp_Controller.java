package com.education.controller;

import com.education.dto.*;
import com.education.service.Otp;
import com.education.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educational/friends/user")
public class Otp_Controller {

    @Autowired
    private Otp otp;

    @Autowired
    private UserInfo userInfo;

    @PostMapping("/getUserInfo")
    public ResponseEntity<UserIdResDto> getUserInfoBasedOnUserId(@RequestBody UserIdReqDto userIdReqDto){
        return ResponseEntity.ok(userInfo.getUserInfo(userIdReqDto));
    }

    @PostMapping("/preLoginUserStatus")
    public ResponseEntity<CommonResponseDto> preLoginUserStatus(@RequestBody GenerateTokenReqDto generateTokenReqDto){
        return ResponseEntity.ok(userInfo.getUserStatus(generateTokenReqDto));
    }

    @PostMapping("/password/sendOTP")
    public ResponseEntity<CommonResponseDto> sendOtpOnEmail(@RequestBody OtpReqDto otpReqDto){
        return ResponseEntity.ok(otp.sendOtpOnEmail(otpReqDto));
    }

    @PostMapping("/password/verifyOTP")
    public ResponseEntity<CommonResponseDto> verifyOtpOnEmail(@RequestBody OtpReqDto otpReqDto){
        return ResponseEntity.ok(otp.verifyOtp(otpReqDto));
    }

    @PostMapping("/password/updateNewPassword")
    public ResponseEntity<CommonResponseDto> updateNewPassword(@RequestBody UpdatePasswordReqDto updatePasswordReqDto){
        return ResponseEntity.ok(otp.updatePassword(updatePasswordReqDto));
    }
}
