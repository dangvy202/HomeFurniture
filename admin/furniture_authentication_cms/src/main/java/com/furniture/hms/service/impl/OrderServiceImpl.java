package com.furniture.hms.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.order.OrderCMSRequest;
import com.furniture.hms.dto.order.OrderCMSResponse;

@Component
public interface OrderServiceImpl {

    List<OrderCMSResponse> getAllOrder();

    String deleteOrder(String orderCode);

    String updateOrderStatus(OrderCMSRequest request);

}
