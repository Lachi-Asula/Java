package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.friends.utils.AdapterUtils.trimStr;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class SMSDto {

    @JsonProperty("MobileNumber")
    private String mobileNum;

    @JsonProperty("EmpStaffId")
    private String empStaffId;
    private String message;

    @JsonProperty("OTPValue")
    private String otpValue;

    public String getMobileNum() {
        return trimStr(mobileNum);
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = trimStr(mobileNum);
    }

    public String getEmpStaffId() {
        return trimStr(empStaffId);
    }

    public void setEmpStaffId(String empStaffId) {
        this.empStaffId = trimStr(empStaffId);
    }

    public String getMessage() {
        return trimStr(message);
    }

    public void setMessage(String message) {
        this.message = trimStr(message);
    }

    public String getOtpValue() {
        return trimStr(otpValue);
    }

    public void setOtpValue(String otpValue) {
        this.otpValue = trimStr(otpValue);
    }

    public SMSDto() {
    }

    public SMSDto(String mobileNum, String empStaffId, String message, String otpValue) {
        this.mobileNum = trimStr(mobileNum);
        this.empStaffId = trimStr(empStaffId);
        this.message = trimStr(message);
        this.otpValue = trimStr(otpValue);
    }
}
