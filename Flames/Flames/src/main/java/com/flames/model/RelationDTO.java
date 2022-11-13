package com.flames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class RelationDTO {
    @JsonProperty("Relation")
    private String relation;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("SecondName")
    private String secondName;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("isSuccessful")
    private String isSuccessful;

    @JsonProperty("ErrorMsg")
    private String errorMsg;
}
