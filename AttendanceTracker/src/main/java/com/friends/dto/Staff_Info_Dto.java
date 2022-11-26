package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Staff_Info_Dto {
    @JsonProperty("EmployeeId")
    private String fldEmpId;

    @JsonProperty("FullName")
    private String fldFullName;

    @JsonProperty("EmailId")
    private String fldEmailId;

    @JsonProperty("Gender")
    private String fldGender;

    @JsonProperty("Specialization")
    private String fldSpecialization;

    @JsonProperty("Password")
    private String fldPassword;

    @JsonProperty("BatchInfo")
    private List<Batch_Info_Dto> fld_Staff_Id;
}
