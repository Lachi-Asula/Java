package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public class GetCalenderInfo {

    @JsonProperty("Years")
    private List<Integer> yearInfo;

    @JsonProperty("Months")
    private List<String> monthInfo;

    public List<Integer> getYearInfo() {
        return yearInfo;
    }

    public void setYearInfo(List<Integer> yearInfo) {
        this.yearInfo = yearInfo;
    }

    public List<String> getMonthInfo() {
        return monthInfo;
    }

    public void setMonthInfo(List<String> monthInfo) {
        this.monthInfo = monthInfo;
    }
}
