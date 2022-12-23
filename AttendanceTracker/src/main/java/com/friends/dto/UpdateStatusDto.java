package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.friends.utils.AdapterUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateStatusDto {

    @JsonProperty("EmployeeId")
    private String empId;

    @JsonProperty("Status")
    private String status;

    public String getEmpId() {
        return trimStr(empId);
    }

    public void setEmpId(String empId) {
        this.empId = trimStr(empId);
    }

    public String getStatus() {
        return status != null ? status.trim().toUpperCase() : "";
    }

    public void setStatus(String status) {
        this.status = status != null ? status.trim().toUpperCase() : "";
    }
}
