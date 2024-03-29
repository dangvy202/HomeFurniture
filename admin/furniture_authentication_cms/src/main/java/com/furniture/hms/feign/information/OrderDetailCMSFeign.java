package com.furniture.hms.feign.information;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.furniture.hms.dto.order.OrderCMSResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInfomationsAdmin", contextId = "OrderDetailCMSFeign", fallbackFactory = OrderDetailCMSFeign.OrderDetailCMSFeignFallBack.class)
public interface OrderDetailCMSFeign {

    @GetMapping("/order-detail/{orderCode}")
    OrderCMSResponse getOrderDetail(@PathVariable("orderCode") String orderCode);

    @Component
    @Slf4j
    class OrderDetailCMSFeignFallBack implements FallbackFactory<OrderDetailCMSFeign> {

	@Override
	public OrderDetailCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
