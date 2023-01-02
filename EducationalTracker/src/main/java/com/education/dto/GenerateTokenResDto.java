package com.education.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.education.utils.SpringUtils.trimStr;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GenerateTokenResDto {

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("ErrorMessage")
    private String errorMsg;


    @JsonProperty("Token")
    private String token;

    @JsonProperty("TimeStamp")
    private String timeStamp;

    public String getStatusCode() {
        return trimStr(statusCode);
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = trimStr(statusCode);
    }

    public String getErrorMsg() {
        return trimStr(errorMsg);
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = trimStr(errorMsg);
    }

    public String getToken() {
        return trimStr(token);
    }

    public void setToken(String token) {
        this.token = trimStr(token);
    }

    public String getTimeStamp() {
        return trimStr(timeStamp);
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = trimStr(timeStamp);
    }
}
