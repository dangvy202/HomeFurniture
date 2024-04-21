package com.furniture.hms.dto.client_subscribe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.hms.enums.CheckMailEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ClientSubscribeCMSRequest {

    @JsonProperty("id_subscribe")
    private int id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("check_mail")
    private CheckMailEnum checkMail;
}
