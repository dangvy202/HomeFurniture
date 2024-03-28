package com.furniture.hms.service.order;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.order.OrderCMSResponse;
import com.furniture.hms.feign.OrderDetailCMSFeign;
import com.furniture.hms.service.spi.OrderDetailServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDetailService implements OrderDetailServiceSpi {

    private final OrderDetailCMSFeign orderDetailFeign;

    @Override
    public OrderCMSResponse getOrderDetail(String orderCode) {
	OrderCMSResponse response = orderDetailFeign.getOrderDetail(orderCode);
	return response;
    }

}
