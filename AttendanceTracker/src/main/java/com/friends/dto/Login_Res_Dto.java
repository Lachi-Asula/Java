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

    @JsonProperty("StaffName")
    private String staffName;

    @JsonProperty("EmployeeName")
    private String empName;

    @JsonProperty("EmployeeId")
    private String empId;

    @JsonProperty("StaffId")
    private String staffId;

    @JsonProperty("BatchNums")
    private List<String> batchNums;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("Message")
    private String errorMsg;

    @JsonProperty("BatchNumber")
    private String batchNum;

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

    public String getEmpId() {
        return empId != null ? empId.trim() : null;
    }

    public void setEmpId(String empId) {
        this.empId = empId != null ? empId.trim() : null;
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

    public String getBatchNum() {
        return batchNum != null ? batchNum.trim() : null;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum != null ? batchNum.trim() : null;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
