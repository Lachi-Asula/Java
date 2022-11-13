package com.flames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@ToString
public class UserDTO {
    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("SecondName")
    private String secondName;
}
