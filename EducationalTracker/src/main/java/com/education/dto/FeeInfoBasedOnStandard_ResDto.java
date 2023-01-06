package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FeeInfoBasedOnStandard_ResDto {

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("Standard")
    private String standard;

    @JsonProperty("Amount")
    private double feeAmount;

    @JsonProperty("ErrorMessage")
    private String errorMsg;

    public String getStatusCode() {
        return trimStr(statusCode);
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = trimStr(statusCode);
    }

    public String getStandard() {
        return trimStr(standard);
    }

    public void setStandard(String standard) {
        this.standard = trimStr(standard);
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public String getErrorMsg() {
        return trimStr(errorMsg);
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = trimStr(errorMsg);
    }
}
