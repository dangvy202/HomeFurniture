package com.furniture.hms.dto.informationContactClient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
public class InformationContactClientRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    @NonNull
    private String email;

    @JsonProperty("phone")
    @NonNull
    private String phone;

    @JsonProperty("address")
    private String address;
}
