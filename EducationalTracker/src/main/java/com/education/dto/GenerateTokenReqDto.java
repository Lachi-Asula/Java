package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateTokenReqDto {

    @JsonProperty("UserId")
    private String userName;

    @JsonProperty("Password")
    private String password;

    public String getUserName() {
        return trimStr(userName);
    }

    public void setUserName(String userName) {
        this.userName = trimStr(userName);
    }

    public String getPassword() {
        return trimStr(password);
    }

    public void setPassword(String password) {
        this.password = trimStr(password);
    }
}
