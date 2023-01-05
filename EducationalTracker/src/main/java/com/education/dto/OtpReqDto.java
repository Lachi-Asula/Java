package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtpReqDto {

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("OtpValue")
    private String otpValue;

    public String getUserId() {
        return trimStr(userId);
    }

    public void setUserId(String userId) {
        this.userId = trimStr(userId);
    }

    public String getEmailId() {
        return trimStr(emailId);
    }

    public void setEmailId(String emailId) {
        this.emailId = trimStr(emailId);
    }

    public String getOtpValue() {
        return trimStr(otpValue);
    }

    public void setOtpValue(String otpValue) {
        this.otpValue = trimStr(otpValue);
    }
}
