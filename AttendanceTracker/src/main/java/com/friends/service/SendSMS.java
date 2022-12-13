package com.friends.service;

import com.friends.dto.CommonResponse;
import com.friends.dto.EmpStaffInfo;
import com.friends.dto.SMSDto;

public interface SendSMS {

    EmpStaffInfo getEmpStaffInfoFromDb(String empId);
    CommonResponse sendSMSOnMobile(SMSDto smsDto);

    CommonResponse verifyOtpOnMobile(SMSDto smsDto);

}
