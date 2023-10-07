package com.furniture.hms.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_price")
    private BigDecimal productPrice;

    @JsonProperty("product_saleoff")
    private BigDecimal productSaleoff;

    @JsonProperty("product_color")
    private String productColor;

    @JsonProperty("product_property")
    private String productProperty;

}
