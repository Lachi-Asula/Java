package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login_Req_Dto {

    @NotNull(message = "EmpId should not be null or Empty")
    @NotEmpty(message = "EmpId should not be Empty or null")
    @JsonProperty("EmpID")
    private String emp_Id;

    @NotNull(message = "Password should not be null or Empty")
    @NotEmpty(message = "Password should not be Empty or null")
    @JsonProperty("Password")
    private String password;
}
