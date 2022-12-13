package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetEmpInfo_BasedOn_BatchNum {
    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("EmployeeList")
    private List<Emp_Info_Dto> empInfoDtoList;

    @JsonProperty("Message")
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public List<Emp_Info_Dto> getEmpInfoDtoList() {
        return empInfoDtoList;
    }

    public void setEmpInfoDtoList(List<Emp_Info_Dto> empInfoDtoList) {
        this.empInfoDtoList = empInfoDtoList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
