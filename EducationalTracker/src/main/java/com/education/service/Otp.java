package com.education.service;

import com.education.dto.CommonResponseDto;
import com.education.dto.OtpReqDto;
import com.education.dto.UpdatePasswordReqDto;

public interface Otp {

    CommonResponseDto sendOtpOnEmail(OtpReqDto otpReqDto);

    void saveOrUpdateOtpData(OtpReqDto otpReqDto);
    CommonResponseDto verifyOtp(OtpReqDto otpReqDto);

    CommonResponseDto updatePassword(UpdatePasswordReqDto updatePasswordReqDto);

    public void sendMail(String emailId, String emailSubject, String emailMessage);
}
