package com.furniture.hms.dto.clientSubscribe;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ClientSubscribeRequest {

    @JsonProperty("email")
    private String email;
}
