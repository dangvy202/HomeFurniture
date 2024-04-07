package com.furniture.hms.dto.information_contact_client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
public class InformationContactClientResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;
}
