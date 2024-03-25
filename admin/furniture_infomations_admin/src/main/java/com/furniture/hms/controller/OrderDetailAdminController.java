package com.furniture.hms.controller;

import java.util.List;

import com.furniture.hms.entity.Order;
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

    private final OrderDetailService orderDetailService;

    @GetMapping("/{orderCode}")
    public ResponseEntity<OrderResponse> getAllOrder(@PathVariable("orderCode") String orderCode) {
	    OrderResponse orderResponse = orderDetailService.getOrderDetailByOrderCode(orderCode);

        if(orderResponse.getStatus() == true && orderResponse.getMessage() == OrderMessage.ORDER_SUCCESS )  {
            return new ResponseEntity<>(orderResponse , HttpStatus.OK);
        }

        return new ResponseEntity<>(orderResponse , HttpStatus.NOT_FOUND);
    }

}
