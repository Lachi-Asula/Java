package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffRegistration_Dto {

    @JsonProperty("StaffId")
    private String fldStaffId;

    @JsonProperty("FullName")
    private String fldFullName;

    @JsonProperty("DateOfBirth")
    private String fldDateOfBirth;

    @JsonProperty("PhoneNumber")
    private String fldPhone;

    @JsonProperty("EmailId")
    private String fldEmailId;

    @JsonProperty("Gender")
    private String fldGender;

    @JsonProperty("Password")
    private String fldPassword;

    public String getFldStaffId() {
        return trimStr(fldStaffId);
    }

    public void setFldStaffId(String fldStaffId) {
        this.fldStaffId = trimStr(fldStaffId);
    }

    public String getFldFullName() {
        return trimStr(fldFullName);
    }

    public void setFldFullName(String fldFullName) {
        this.fldFullName = trimStr(fldFullName);
    }

    public String getFldDateOfBirth() {
        return trimStr(fldDateOfBirth);
    }

    public void setFldDateOfBirth(String fldDateOfBirth) {
        this.fldDateOfBirth = trimStr(fldDateOfBirth);
    }

    public String getFldPhone() {
        return trimStr(fldPhone);
    }

    public void setFldPhone(String fldPhone) {
        this.fldPhone = trimStr(fldPhone);
    }

    public String getFldEmailId() {
        return trimStr(fldEmailId);
    }

    public void setFldEmailId(String fldEmailId) {
        this.fldEmailId = trimStr(fldEmailId);
    }

    public String getFldGender() {
        return trimStr(fldGender);
    }

    public void setFldGender(String fldGender) {
        this.fldGender = trimStr(fldGender);
    }

    public String getFldPassword() {
        return trimStr(fldPassword);
    }

    public void setFldPassword(String fldPassword) {
        this.fldPassword = trimStr(fldPassword);
    }
}
