package com.furniture.hms.dto.informationOrder;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationOrderRequest {

    @JsonProperty("address")
    private String address;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("orderCode")
    private String orderCode;
}
