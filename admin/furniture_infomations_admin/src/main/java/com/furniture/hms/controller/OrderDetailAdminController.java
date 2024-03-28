package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.service.order.OrderDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order-detail")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class OrderDetailAdminController {

    private final OrderDetailService orderDetailService;

    @GetMapping("/{orderCode}")
    public ResponseEntity<OrderResponse> getOrderDetail(@PathVariable("orderCode") String orderCode) {
	OrderResponse orderResponse = orderDetailService.getOrderDetailByOrderCode(orderCode);
	return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

}
