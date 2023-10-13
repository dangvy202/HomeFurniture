package com.furniture.hms.dto.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Boolean status;

    private String error;

    private String message;

    List<OrderDetail> orderDetails;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class OrderDetail {
        private String orderId;

        private String orderStatus;

        private Integer orderQuantity;

        private Product product;

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Product {
            private String productName;

            private BigDecimal productPrice;

            private BigDecimal productSaleoff;

            private Picture picture;

            @Data
            @FieldDefaults(level = AccessLevel.PRIVATE)
            public static class Picture {
                private String picture;
            }
        }

    }
}
