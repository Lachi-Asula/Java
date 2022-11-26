package com.friends.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Batch_Info_Dto {
    @JsonProperty("ID")
    private int fldID;

    @JsonProperty("BatchName")
    private String fldBatchName;
}
