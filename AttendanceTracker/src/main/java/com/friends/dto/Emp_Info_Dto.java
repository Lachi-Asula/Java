package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Emp_Info_Dto {
    @JsonProperty("EmpID")
    private String fldEmpId;

    @JsonProperty("FullName")
    private String fldFullName;

    @JsonProperty("EmailId")
    private String fldEmailId;

    @JsonProperty("Gender")
    private String fldGender;

    @JsonProperty("BatchNumber")
    private String fldBatchNum;

    @JsonProperty("PhoneNumber")
    private String fldPhoneNum;

    @JsonProperty("EmpStatus")
    private String fldStatus;
}
