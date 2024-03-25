package com.furniture.hms.dto.information_order;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationOrderResponse {

    private String address;

    private String email;

    private String userName;

    private BigInteger phone;

    private Order order;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Order {

	private String orderCode;

	private String orderStatus;

	private BigDecimal totalOrder;

	private Instant updateDate;

	private String userName;

	private String phone;

	private String email;
    }

}
