package com.furniture.hms.dto.information_contact_client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
public class InformationContactClientCMSRequest {

    @JsonProperty("id")
    @NonNull
    private int id;

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
