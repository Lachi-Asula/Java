package com.education.dto;

import com.education.model.Standard_Entity;
import com.education.model.Subject_Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffRegistration_Dto {

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

    @JsonProperty("Role")
    private String fldSpecialization;

    @JsonProperty("Password")
    private String fldPassword;

    @JsonProperty("Standards")
    private List<String> standards;

    @JsonProperty("Subjects")
    private List<String> subjects;

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

    public List<String> getStandards() {
        return standards;
    }

    public void setStandards(List<String> standards) {
        this.standards = standards;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
