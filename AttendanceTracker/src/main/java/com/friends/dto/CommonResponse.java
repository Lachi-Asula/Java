package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponse {
    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("Message")
    private String message;
}
