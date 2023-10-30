package com.furniture.hms.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;
}
