package com.furniture.hms.service.spi;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.order.OrderCMSResponse;

@Component
public interface OrderDetailServiceSpi {

    OrderCMSResponse getOrderDetail(String orderCode);
}
