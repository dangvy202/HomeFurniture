package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderCMSResponse;
import com.furniture.hms.service.order.OrderDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/order-detail")
@RequiredArgsConstructor
public class OrderDetailCMSController {

    private final OrderDetailService orderDetailService;

    @GetMapping("/{orderCode}")
    public ResponseEntity<OrderCMSResponse> getOrderDetail(@PathVariable("orderCode") String orderCode) {
	OrderCMSResponse orderResponse = orderDetailService.getOrderDetail(orderCode);

	if (orderResponse.getStatus() == true && orderResponse.getMessage() == OrderMessage.ORDER_SUCCESS) {
	    return new ResponseEntity<>(orderResponse, HttpStatus.OK);
	}

	return new ResponseEntity<>(orderResponse, HttpStatus.NOT_FOUND);
    }
}
