package com.furniture.hms.dto.wishlist;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Setter
@Getter
public class WishlistOrderResponse {

    private Boolean status;

    private String error;

    private String message;

    private User user;

    private List<Product> product;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class User {
	@JsonProperty("email")
	private String email;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Product {

	@JsonProperty("productName")
	private String productName;

	@JsonProperty("productPrice")
	private BigDecimal productPrice;

	@JsonProperty("productSaleoff")
	private BigDecimal productSaleoff;

	@JsonProperty("quantity")
	private Integer quantity;

	private Picture picture;

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class Picture {

	    @JsonProperty("picture")
	    private String picture;
	}
    }

}
