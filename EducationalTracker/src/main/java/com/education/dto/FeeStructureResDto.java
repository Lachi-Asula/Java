package com.education.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Map;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FeeStructureResDto {

    @JsonProperty("FeeStructure")
    private Map<String, Double> feeInfo;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    public Map<String, Double> getFeeInfo() {
        return feeInfo;
    }

    public void setFeeInfo(Map<String, Double> feeInfo) {
        this.feeInfo = feeInfo;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
