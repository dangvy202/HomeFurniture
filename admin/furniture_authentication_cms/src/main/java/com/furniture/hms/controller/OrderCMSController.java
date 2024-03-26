package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.order.OrderCMSResponse;
import com.furniture.hms.feign.OrderCMSFeign;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/order")
@RequiredArgsConstructor
public class OrderCMSController {

    private final OrderCMSFeign orderCMSFeign;

    @GetMapping
    public ResponseEntity<List<OrderCMSResponse>> getAllOrder() {
	var response = orderCMSFeign.getAllOrder();
	return new ResponseEntity<List<OrderCMSResponse>>(response, HttpStatus.OK);
    }
}
