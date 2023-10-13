package com.furniture.hms.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @JsonProperty("order_quantity")
    private Integer orderQuantity;

    @JsonProperty("id_product")
    private Integer idProduct;

    @JsonProperty("user")
    private User user;


    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class User {
        private String email;
    }
}
