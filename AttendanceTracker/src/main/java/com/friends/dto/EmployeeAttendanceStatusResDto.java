package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeAttendanceStatusResDto {

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("PresentDays")
    private List<PresentDay> presentDays;

    @JsonProperty("AbsentDays")
    private List<Absentday> absentDays;

    @JsonProperty("PresentDaysCount")
    private String presentDaysCount;

    @JsonProperty("AbsentDaysCount")
    private String absentDaysCount;

    @JsonProperty("ErrorMessage")
    private String errorMsg;
}
