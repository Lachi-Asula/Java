package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.List;

import static com.friends.utils.AdapterUtils.trimStr;

@ToString
public class Staff_Info_Dto {
    @JsonProperty("EmployeeId")
    private String fldEmpId;

    @JsonProperty("FullName")
    private String fldFullName;

    @JsonProperty("EmailId")
    private String fldEmailId;

    @JsonProperty("PhoneNum")
    private String fldPhone;

    @JsonProperty("Gender")
    private String fldGender;

    @JsonProperty("Specialization")
    private String fldSpecialization;

    @JsonProperty("Password")
    private String fldPassword;

    @JsonProperty("BatchInfo")
    private List<Batch_Info_Dto> fld_Staff_Id;

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

    public String getFldPhone() {
        return trimStr(fldPhone);
    }

    public void setFldPhone(String fldPhone) {
        this.fldPhone = trimStr(fldPhone);
    }

    public String getFldGender() {
        return trimStr(fldGender);
    }

    public void setFldGender(String fldGender) {
        this.fldGender = trimStr(fldGender);
    }

    public String getFldSpecialization() {
        return trimStr(fldSpecialization);
    }

    public void setFldSpecialization(String fldSpecialization) {
        this.fldSpecialization = trimStr(fldSpecialization);
    }

    public String getFldPassword() {
        return trimStr(fldPassword);
    }

    public void setFldPassword(String fldPassword) {
        this.fldPassword = trimStr(fldPassword);
    }

    public List<Batch_Info_Dto> getFld_Staff_Id() {
        return fld_Staff_Id;
    }

    public void setFld_Staff_Id(List<Batch_Info_Dto> fld_Staff_Id) {
        this.fld_Staff_Id = fld_Staff_Id;
    }
}
