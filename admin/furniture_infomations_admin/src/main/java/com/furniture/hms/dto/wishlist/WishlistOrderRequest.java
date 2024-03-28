package com.furniture.hms.dto.wishlist;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class WishlistOrderRequest {

    @JsonProperty("id_product")
    private Integer idProduct;

    @JsonProperty("email")
    private String email;

}
