package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login_Res_Dto {
    @JsonProperty("Role")
    private String role;

    @JsonProperty("StaffOrEmployeeName")
    private String empName;

    @JsonProperty("BatchNums")
    private List<String> batchNums;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("Message")
    private String errorMsg;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<String> getBatchNums() {
        return batchNums;
    }

    public void setBatchNums(List<String> batchNums) {
        this.batchNums = batchNums;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
