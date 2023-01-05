package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePasswordReqDto {

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("NewPassword")
    private String newPassword;

    public String getUserId() {
        return trimStr(userId);
    }

    public void setUserId(String userId) {
        this.userId = trimStr(userId);
    }

    public String getNewPassword() {
        return trimStr(newPassword);
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = trimStr(newPassword);
    }
}
