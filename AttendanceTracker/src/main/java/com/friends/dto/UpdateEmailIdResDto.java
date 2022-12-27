package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.friends.utils.AdapterUtils.trimStr;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UpdateEmailIdResDto {

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("EmployeeId")
    private String empId;

    @JsonProperty("NewEmailId")
    private String emailId;

    public String getStatusCode() {
        return trimStr(statusCode);
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = trimStr(statusCode);
    }

    public String getMessage() {
        return trimStr(message);
    }

    public void setMessage(String message) {
        this.message = trimStr(message);
    }

    public String getEmpId() {
        return trimStr(empId);
    }

    public void setEmpId(String empId) {
        this.empId = trimStr(empId);
    }

    public String getEmailId() {
        return trimStr(emailId);
    }

    public void setEmailId(String emailId) {
        this.emailId = trimStr(emailId);
    }

}
