package com.friends.dto;

import static com.friends.utils.AdapterUtils.trimStr;

public class Sms_Info_Dto {

    private String empId;
    private String otpValue;

    public String getEmpId() {
        return trimStr(empId);
    }

    public void setEmpId(String empId) {
        this.empId = trimStr(empId);
    }

    public String getOtpValue() {
        return trimStr(otpValue);
    }

    public void setOtpValue(String otpValue) {
        this.otpValue = trimStr(otpValue);
    }
}
