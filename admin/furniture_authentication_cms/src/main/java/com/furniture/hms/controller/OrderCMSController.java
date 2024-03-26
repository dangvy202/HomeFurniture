package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.OrderMessage;
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

    @DeleteMapping("/delete/{orderCode}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderCode") String orderCode) {
	var response = orderCMSFeign.deleteOrder(orderCode);

	if (response == OrderMessage.ORDER_SUCCESS) {
	    return new ResponseEntity<>(OrderMessage.ORDER_SUCCESS, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
}
