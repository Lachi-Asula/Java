package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import static com.friends.utils.AdapterUtils.trimStr;

public class Batch_Info_Dto {
    @JsonProperty("ID")
    private int fldID;

    @JsonProperty("BatchName")
    private String fldBatchName;

    public int getFldID() {
        return fldID;
    }

    public void setFldID(int fldID) {
        this.fldID = fldID;
    }

    public String getFldBatchName() {
        return trimStr(fldBatchName);
    }

    public void setFldBatchName(String fldBatchName) {
        this.fldBatchName = trimStr(fldBatchName);
    }
}
