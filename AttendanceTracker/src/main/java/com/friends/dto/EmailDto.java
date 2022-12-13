package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.friends.utils.AdapterUtils.trimStr;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailDto {
    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("EmpStaffId")
    private String empStaffId;

    @JsonProperty("OTPValue")
    private String otpValue;
    private String message;

    public String getEmailId() {
        return trimStr(emailId);
    }

    public void setEmailId(String emailId) {
        this.emailId = trimStr(emailId);
    }

    public String getEmpStaffId() {
        return trimStr(empStaffId);
    }

    public void setEmpStaffId(String empStaffId) {
        this.empStaffId = trimStr(empStaffId);
    }

    public String getOtpValue() {
        return trimStr(otpValue);
    }

    public void setOtpValue(String otpValue) {
        this.otpValue = trimStr(otpValue);
    }

    public String getMessage() {
        return trimStr(message);
    }

    public void setMessage(String message) {
        this.message = trimStr(message);
    }

    public EmailDto() {
    }

    public EmailDto(String emailId, String empStaffId, String otpValue, String message) {
        this.emailId = trimStr(emailId);
        this.empStaffId = trimStr(empStaffId);
        this.otpValue = trimStr(otpValue);
        this.message = trimStr(message);
    }
}
