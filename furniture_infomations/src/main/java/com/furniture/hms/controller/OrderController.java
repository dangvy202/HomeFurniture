package com.furniture.hms.controller;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderRequest;
import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{}")
    public ResponseEntity<List<OrderResponse>> getOrderByUser() {
        orderService.getOrderByUserDetail();
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody List<OrderRequest> requests) {
        String response = orderService.addOrder(requests);
        if(response == OrderMessage.ORDER_SUCCESS) {
            return new ResponseEntity<>(OrderMessage.ORDER_SUCCESS , HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(OrderMessage.ORDER_FAIL,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
