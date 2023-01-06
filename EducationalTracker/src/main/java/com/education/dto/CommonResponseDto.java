package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.education.utils.SpringUtils.trimStr;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommonResponseDto {

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    @JsonProperty("SuccessMessage")
    private String successMsg;

    @JsonProperty("UserId")
    private String userId;

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

    public String getSuccessMsg() {
        return trimStr(successMsg);
    }

    public void setSuccessMsg(String successMsg) {
        this.successMsg = trimStr(successMsg);
    }

    public String getUserId() {
        return trimStr(userId);
    }

    public void setUserId(String userId) {
        this.userId = trimStr(userId);
    }

    public String getTimeStamp() {
        return trimStr(timeStamp);
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = trimStr(timeStamp);
    }
}
