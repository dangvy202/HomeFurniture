package com.furniture.hms.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    List<ProductDetail> productDetailList;

    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Data
    public static class ProductDetail {

    }
}
