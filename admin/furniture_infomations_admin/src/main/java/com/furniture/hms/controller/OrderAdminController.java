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

import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.service.order.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class OrderAdminController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrder() {
	var orderResponse = orderService.getAllOrder();
	return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderCode}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderCode") String orderCode) {
//	var response = orderService.deleteOrder(orderCode);
//
//	if (response == OrderMessage.ORDER_SUCCESS) {
//	    return new ResponseEntity<>(response, HttpStatus.OK);
//	} else {
//	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	return null;
    }

}
