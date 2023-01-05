package com.education.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

import static com.education.utils.SpringUtils.trimStr;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserIdResDto {

    @JsonProperty("UserId")
    private String userId;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("DateOfBirth")
    private String dateOfBirth;

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("Role")
    private String role;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    @JsonProperty("Standards")
    private List<String> standards;

    @JsonProperty("Subjects")
    private List<String> subjects;


    public String getUserId() {
        return trimStr(userId);
    }

    public void setUserId(String userId) {
        this.userId = trimStr(userId);
    }

    public String getFullName() {
        return trimStr(fullName);
    }

    public void setFullName(String fullName) {
        this.fullName = trimStr(fullName);
    }

    public String getDateOfBirth() {
        return trimStr(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = trimStr(dateOfBirth);
    }

    public String getEmailId() {
        return trimStr(emailId);
    }

    public void setEmailId(String emailId) {
        this.emailId = trimStr(emailId);
    }

    public String getRole() {
        return trimStr(role);
    }

    public void setRole(String role) {
        this.role = trimStr(role);
    }

    public String getStatusCode() {
        return trimStr(statusCode);
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = trimStr(statusCode);
    }

    public String getErrorMsg() {
        return trimStr(errorMsg);
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = trimStr(errorMsg);
    }
}
