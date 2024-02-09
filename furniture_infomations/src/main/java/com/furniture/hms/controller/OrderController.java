package com.furniture.hms.controller;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderRequest;
import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.service.order.OrderService;
import jakarta.ws.rs.PathParam;
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

    @DeleteMapping("/delete/{idOrder}")
    public ResponseEntity<String> getOrderByUser(@PathVariable("idOrder") String idOrder ) {
        String response = orderService.deleteOrder(idOrder);
        if(response == OrderMessage.ORDER_FAIL) {
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(response , HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderByOrderId (@PathVariable("id") String idOrder , @RequestBody OrderRequest request) {
        String response = orderService.updateOrder(idOrder,request);
        if(response == OrderMessage.ORDER_FAIL) {
            return new ResponseEntity<>(OrderMessage.ORDER_FAIL,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(OrderMessage.ORDER_SUCCESS,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> getOrderByEmailUser(@RequestHeader("email") String email) {
        var orderResponse = orderService.getOrderByEmailUser(email);
        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<OrderResponse> getOrderDetailByUser(@RequestHeader("email") String email, @RequestHeader("orderCode") String orderCode) {
        OrderResponse orderResponse = orderService.getOrderDetailByUser(email,orderCode);
        if(orderResponse.getStatus() == true && orderResponse.getMessage() == OrderMessage.ORDER_SUCCESS )  {
            return new ResponseEntity<>(orderResponse , HttpStatus.OK);
        }else if (orderResponse.getStatus() == true && orderResponse.getMessage() == OrderMessage.ORDER_EXIST){
            return new ResponseEntity<>(orderResponse , HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(orderResponse , HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<OrderResponse> addOrder(@RequestBody List<OrderRequest> requests) {
        OrderResponse response = orderService.addOrder(requests);
        if(response.getMessage() == OrderMessage.ORDER_SUCCESS) {
            return new ResponseEntity<>(response , HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
