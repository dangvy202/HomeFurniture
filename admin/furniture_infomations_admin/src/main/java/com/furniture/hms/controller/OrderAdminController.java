package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
