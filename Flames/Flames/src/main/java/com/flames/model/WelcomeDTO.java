package com.flames.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WelcomeDTO {
    @JsonProperty("Greetings")
    private String message;
}
