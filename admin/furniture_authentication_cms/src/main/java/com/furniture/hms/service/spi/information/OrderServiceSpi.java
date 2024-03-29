package com.furniture.hms.service.spi.information;

import java.util.List;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.order.OrderCMSRequest;
import com.furniture.hms.dto.order.OrderCMSResponse;

@Component
public interface OrderServiceSpi {

    List<OrderCMSResponse> getAllOrder();

    String deleteOrder(String orderCode);

    String updateOrderStatus(OrderCMSRequest request);

}
