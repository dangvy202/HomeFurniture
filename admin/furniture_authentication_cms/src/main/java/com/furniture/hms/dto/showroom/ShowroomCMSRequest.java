package com.furniture.hms.dto.showroom;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShowroomCMSRequest {
    @JsonProperty("address")
    private String address;

    @JsonProperty("dayOpen")
    private String dayOpen;

    @JsonProperty("timeOpen")
    private String timeOpen;

    @JsonProperty("mail")
    private String mail;

    @JsonProperty("phone")
    private String phone;
}
