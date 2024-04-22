package com.furniture.hms.dto.information_contact_admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InformationContactAdminCMSRequest {
    @JsonProperty("id_admin")
    private int id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("hotline")
    private String hotline;
}
