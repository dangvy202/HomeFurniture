package com.furniture.hms.service.information;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.order.OrderCMSRequest;
import com.furniture.hms.dto.order.OrderCMSResponse;
import com.furniture.hms.feign.information.OrderCMSFeign;
import com.furniture.hms.service.spi.information.OrderServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderServiceSpi {

    private final OrderCMSFeign orderFeign;

    @Override
    public List<OrderCMSResponse> getAllOrder() {
	List<OrderCMSResponse> response = orderFeign.getAllOrder();
	return response;
    }

    @Override
    public String deleteOrder(String orderCode) {
	String response = orderFeign.deleteOrder(orderCode);
	return response;
    }

    @Override
    public String updateOrderStatus(OrderCMSRequest request) {
	String response = orderFeign.updateOrderStatus(request);
	return response;
    }

}
