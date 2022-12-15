package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import static com.friends.utils.AdapterUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Login_Req_Dto {

    @JsonProperty("EmpID")
    private String emp_Id;

    @JsonProperty("Password")
    private String password;

    public String getEmp_Id() {
        return trimStr(emp_Id);
    }

    public void setEmp_Id(String emp_Id) {
        this.emp_Id = trimStr(emp_Id);
    }

    public String getPassword() {
        return trimStr(password);
    }

    public void setPassword(String password) {
        this.password = trimStr(password);
    }
}
