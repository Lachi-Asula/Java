package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;


@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpStaffInfo {
    @JsonProperty("EmpId")
    private String empStaffId;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("PhoneNumber")
    private String phoneNum;

    @JsonProperty("EmailId")
    private String emailId;

    @JsonProperty("ErrorCode")
    private String errorCode;

    @JsonProperty("ErrorMsg")
    private String errorMsg;

    public String getEmpStaffId() {
        return trimStr(empStaffId);
    }

    public void setEmpStaffId(String empStaffId) {
        this.empStaffId = trimStr(empStaffId);
    }

    public String getFullName() {
        return trimStr(fullName);
    }

    public void setFullName(String fullName) {
        this.fullName = trimStr(fullName);
    }

    public String getPhoneNum() {
        return trimStr(phoneNum);
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = trimStr(phoneNum);
    }

    public String getEmailId() {
        return trimStr(emailId);
    }

    public void setEmailId(String emailId) {
        this.emailId = trimStr(emailId);
    }

    public String getErrorCode() {
        return trimStr(errorCode);
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = trimStr(errorCode);
    }

    public String getErrorMsg() {
        return trimStr(errorMsg);
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = trimStr(errorMsg);
    }

    public EmpStaffInfo() {
    }

    public EmpStaffInfo(String empStaffId, String fullName, String phoneNum, String emailId, String errorCode, String errorMsg) {
        this.empStaffId = trimStr(empStaffId);
        this.fullName = trimStr(fullName);
        this.phoneNum = trimStr(phoneNum);
        this.emailId = trimStr(emailId);
        this.errorCode = trimStr(errorCode);
        this.errorMsg = trimStr(errorMsg);
    }

    private String trimStr(String value){
        if(StringUtils.isNotBlank(value)){
            return value.trim();
        }else {
            return null;
        }
    }
}
