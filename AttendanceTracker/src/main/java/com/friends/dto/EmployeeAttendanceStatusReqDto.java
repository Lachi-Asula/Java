package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.friends.utils.AdapterUtils.trimStr;

public class EmployeeAttendanceStatusReqDto {

    @JsonProperty("EmployeeId")
    private String empId;

    @JsonProperty("BatchNumber")
    private String batchNum;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("Month")
    private String month;

    public String getEmpId() {
        return trimStr(empId);
    }

    public void setEmpId(String empId) {
        this.empId = trimStr(empId);
    }

    public String getBatchNum() {
        return trimStr(batchNum);
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = trimStr(batchNum);
    }

    public String getYear() {
        return trimStr(year);
    }

    public void setYear(String year) {
        this.year = trimStr(year);
    }

    public String getMonth() {
        return trimStr(month);
    }

    public void setMonth(String month) {
        this.month = trimStr(month);
    }
}
