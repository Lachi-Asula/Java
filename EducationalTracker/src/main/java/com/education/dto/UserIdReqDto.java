package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserIdReqDto {

    @JsonProperty("UserId")
    private String userId;

    public String getUserId() {
        return trimStr(userId);
    }

    public void setUserId(String userId) {
        this.userId = trimStr(userId);
    }
}
