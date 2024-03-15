package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.service.order.OrderDetailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order-detail")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class OrderDetailAdminController {

    private final OrderDetailService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrder() {
	var orderResponse = orderService.getAllOrder();
	return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderCode}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderCode") String orderCode) {
	var response = orderService.deleteOrder(orderCode);

	if (response == OrderMessage.ORDER_SUCCESS) {
	    return new ResponseEntity<>(OrderMessage.ORDER_SUCCESS, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

}
