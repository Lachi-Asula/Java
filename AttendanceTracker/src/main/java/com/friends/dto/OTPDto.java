package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.friends.utils.AdapterUtils.trimStr;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OTPDto {

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("EmpStaffId")
    private String empStaffId;
    private String message;

    @JsonProperty("OTPValue")
    private String otpValue;

    @JsonProperty("Password")
    private String password;

    public String getEmailId() {
        return trimStr(emailId);
    }

    public void setMobileNum(String emailId) {
        this.emailId = trimStr(emailId);
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

    public void setEmailId(String emailId) {
        this.emailId = trimStr(emailId);
    }

    public String getPassword() {
        return trimStr(password);
    }

    public void setPassword(String password) {
        this.password = trimStr(password);
    }

    public OTPDto() {
    }

    public OTPDto(String emailId, String empStaffId, String message, String otpValue, String password) {
        this.emailId = emailId;
        this.empStaffId = empStaffId;
        this.message = message;
        this.otpValue = otpValue;
        this.password = password;
    }
}
