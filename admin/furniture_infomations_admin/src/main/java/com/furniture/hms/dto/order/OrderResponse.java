package com.furniture.hms.dto.order;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;
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

    private int numberOrder;

    private String orderCode;

    private String orderStatus;

    private BigDecimal totalOrder;

    private Instant updateDate;

    private String userName;

    private String phone;

    private String email;

    List<OrderDetail> orderDetails;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class OrderDetail {
        private String orderId;

        private Product product;

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Product {
            private String productName;

            private BigDecimal productPrice;

            private BigDecimal productSaleoff;

            private Integer orderQuantity;

            private Picture picture;

            @Data
            @FieldDefaults(level = AccessLevel.PRIVATE)
            public static class Picture {
                private String picture;
            }
        }

    }
}
