package com.education.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

import static com.education.utils.SpringUtils.trimStr;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllStudentsInfoBasedOnStandard_ResDto {

    @JsonProperty("StudentsInfo")
    private List<StudentRegistration_Dto> studentRegistrationDtoList;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("Standard")
    private String standard;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    public List<StudentRegistration_Dto> getStudentRegistrationDtoList() {
        return studentRegistrationDtoList;
    }

    public void setStudentRegistrationDtoList(List<StudentRegistration_Dto> studentRegistrationDtoList) {
        this.studentRegistrationDtoList = studentRegistrationDtoList;
    }

    public String getStatusCode() {
        return trimStr(statusCode);
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = trimStr(statusCode);
    }

    public String getStandard() {
        return trimStr(standard);
    }

    public void setStandard(String standard) {
        this.standard = trimStr(standard);
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
