package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Login_Res_Dto {
    @JsonProperty("Role")
    private String role;

    @JsonProperty("BatchNums")
    private List<String> batchNums;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("ErrorMsg")
    private String errorMsg;
}
