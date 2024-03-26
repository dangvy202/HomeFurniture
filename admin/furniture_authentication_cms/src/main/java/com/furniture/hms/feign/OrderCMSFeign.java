package com.furniture.hms.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.furniture.hms.dto.order.OrderCMSResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInfomationsAdmin", fallbackFactory = OrderCMSFeign.OrderCMSFeignFallBack.class)
public interface OrderCMSFeign {

    @GetMapping("/order")
    List<OrderCMSResponse> getAllOrder();

    @DeleteMapping("/delete/{orderCode}")
    String deleteOrder(@PathVariable("orderCode") String orderCode);

    @Component
    @Slf4j
    class OrderCMSFeignFallBack implements FallbackFactory<OrderCMSFeign> {

	@Override
	public OrderCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
