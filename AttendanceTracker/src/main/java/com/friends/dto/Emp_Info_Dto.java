package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.ToString;

import static com.friends.utils.AdapterUtils.trimStr;

public class Emp_Info_Dto {
    @JsonProperty("EmpID")
    private String fldEmpId;

    @JsonProperty("FullName")
    private String fldFullName;

    @JsonProperty("EmailId")
    private String fldEmailId;

    @JsonProperty("DOB")
    private String fldDob;

    @JsonProperty("Gender")
    private String fldGender;

    @JsonProperty("BatchNumber")
    private String fldBatchNum;

    @JsonProperty("PhoneNumber")
    private String fldPhoneNum;

    @JsonProperty("EmpStatus")
    private String fldStatus;

    @JsonProperty("Password")
    private String fldPassword;

    public String getFldEmpId() {
        return trimStr(fldEmpId);
    }

    public void setFldEmpId(String fldEmpId) {
        this.fldEmpId = trimStr(fldEmpId);
    }

    public String getFldFullName() {
        return trimStr(fldFullName);
    }

    public void setFldFullName(String fldFullName) {
        this.fldFullName = trimStr(fldFullName);
    }

    public String getFldEmailId() {
        return trimStr(fldEmailId);
    }

    public void setFldEmailId(String fldEmailId) {
        this.fldEmailId = trimStr(fldEmailId);
    }

    public String getFldDob() {
        return trimStr(fldDob);
    }

    public void setFldDob(String fldDob) {
        this.fldDob = trimStr(fldDob);
    }

    public String getFldGender() {
        return trimStr(fldGender);
    }

    public void setFldGender(String fldGender) {
        this.fldGender = trimStr(fldGender);
    }

    public String getFldBatchNum() {
        return trimStr(fldBatchNum);
    }

    public void setFldBatchNum(String fldBatchNum) {
        this.fldBatchNum = trimStr(fldBatchNum);
    }

    public String getFldPhoneNum() {
        return trimStr(fldPhoneNum);
    }

    public void setFldPhoneNum(String fldPhoneNum) {
        this.fldPhoneNum = trimStr(fldPhoneNum);
    }

    public String getFldStatus() {
        return trimStr(fldStatus);
    }

    public void setFldStatus(String fldStatus) {
        this.fldStatus = trimStr(fldStatus);
    }

    public String getFldPassword() {
        return trimStr(fldPassword);
    }

    public void setFldPassword(String fldPassword) {
        this.fldPassword = trimStr(fldPassword);
    }
}
