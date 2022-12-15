package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.Date;

import static com.friends.utils.AdapterUtils.trimStr;

@Builder
public class CommonException extends RuntimeException{
    @JsonProperty("ErrorCode")
    private String errorCode;

    @JsonProperty("StatusCode")
    private HttpStatus statusCode;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    @JsonProperty("TimeStamp")
    private String timeStamp;

    public String getErrorCode() {
        return trimStr(errorCode);
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = trimStr(errorCode);
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return trimStr(errorMsg);
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = trimStr(errorMsg);
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public CommonException() {
    }

    public CommonException(String errorCode, HttpStatus statusCode, String errorMsg, String timeStamp) {
        this.errorCode = trimStr(errorCode);
        this.statusCode = statusCode;
        this.errorMsg = trimStr(errorMsg);
        this.timeStamp = timeStamp;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
