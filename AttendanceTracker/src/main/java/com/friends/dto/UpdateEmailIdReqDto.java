package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.friends.utils.AdapterUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateEmailIdReqDto {

    @JsonProperty("EmployeeId")
    private String empId;

    @JsonProperty("DOB")
    private String dateOfBirth;

    @JsonProperty("NewEmailId")
    private String newEmailId;

    public String getEmpId() {
        return trimStr(empId);
    }

    public void setEmpId(String empId) {
        this.empId = trimStr(empId);
    }

    public String getDateOfBirth() {
        return trimStr(dateOfBirth);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = trimStr(dateOfBirth);
    }

    public String getNewEmailId() {
        return trimStr(newEmailId);
    }

    public void setNewEmailId(String newEmailId) {
        this.newEmailId = trimStr(newEmailId);
    }
}
