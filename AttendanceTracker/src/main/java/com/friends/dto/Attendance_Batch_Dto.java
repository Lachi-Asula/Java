package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


import static com.friends.utils.AdapterUtils.trimStr;

public class Attendance_Batch_Dto {

    @JsonProperty("Id")
    private int id;

    @JsonProperty("EmpId")
    private String fldEmpId;

    @JsonProperty("BatchNum")
    private String batchNum;

    @JsonProperty("EmpFullName")
    private String fldFullName;

    @JsonProperty("StaffName")
    private String fldStaffName;

    @JsonProperty("Status")
    private String fldStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFldEmpId() {
        return trimStr(fldEmpId);
    }

    public void setFldEmpId(String fldEmpId) {
        this.fldEmpId = trimStr(fldEmpId);
    }

    public String getBatchNum() {
        return trimStr(batchNum);
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = trimStr(batchNum);
    }

    public String getFldFullName() {
        return trimStr(fldFullName);
    }

    public void setFldFullName(String fldFullName) {
        this.fldFullName = trimStr(fldFullName);
    }

    public String getFldStaffName() {
        return trimStr(fldStaffName);
    }

    public void setFldStaffName(String fldStaffName) {
        this.fldStaffName = trimStr(fldStaffName);
    }

    public String getFldStatus() {
        return (fldStatus != null && !fldStatus.isEmpty()) ? trimStr(fldStatus).toUpperCase() : Constants.statuc_Absent;
    }

    public void setFldStatus(String fldStatus) {
        this.fldStatus = trimStr(fldStatus);
    }
}
