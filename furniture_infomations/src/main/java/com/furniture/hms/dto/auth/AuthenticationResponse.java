package com.furniture.hms.dto.auth;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthenticationResponse {
    private boolean status;
    private String error;
    private String message;
    private String token;
    private String expired;
}
