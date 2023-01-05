package com.education.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.education.utils.SpringUtils.trimStr;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeeStructureUpdateReqDto {

    @JsonProperty("Standard")
    private String fldStandard;

    @JsonProperty("FeeAmount")
    private double amount;

    public String getFldStandard() {
        return trimStr(fldStandard);
    }

    public void setFldStandard(String fldStandard) {
        this.fldStandard = trimStr(fldStandard);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
