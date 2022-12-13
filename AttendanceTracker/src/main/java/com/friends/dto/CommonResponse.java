package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import static com.friends.utils.AdapterUtils.trimStr;

@Builder
public class CommonResponse {
    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("Message")
    private String message;

    public String getStatusCode() {
        return trimStr(statusCode);
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = trimStr(statusCode);
    }

    public String getMessage() {
        return trimStr(message);
    }

    public void setMessage(String message) {
        this.message = trimStr(message);
    }
}
