package com.friends.service;

import com.friends.dto.CommonResponse;
import com.friends.dto.EmpStaffInfo;
import com.friends.dto.OTPDto;

public interface OTPService {

    EmpStaffInfo getEmpStaffInfoFromDb(String empId);

    CommonResponse forgotPassword(OTPDto otpDto);

    void sendGreetingsToEmail(String emailId, String userId, String userName, String passWord);

    CommonResponse updatePassword(OTPDto otpDto);

    CommonResponse verifyOtp(OTPDto smsDto);

}
