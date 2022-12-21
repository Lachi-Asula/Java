package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Date;

@Builder
public class PresentDay {

    @JsonProperty("Date")
    private String presentDay;

    @JsonProperty("StaffName")
    private String staffName;
}
