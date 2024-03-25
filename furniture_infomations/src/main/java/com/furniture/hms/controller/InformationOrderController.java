package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.InformationOrderMessage;
import com.furniture.hms.dto.information_order.InformationOrderRequest;
import com.furniture.hms.dto.information_order.InformationOrderResponse;
import com.furniture.hms.service.information_order.InformationOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/information-order")
@RequiredArgsConstructor
public class InformationOrderController {

    private final InformationOrderService informationOrderService;

    @GetMapping("/order-code/{orderCode}")
    public ResponseEntity<InformationOrderResponse> getInformationOrderByCode(
	    @PathVariable("orderCode") String orderCode) {
	InformationOrderResponse response = informationOrderService.getInformationOrderByOrderCode(orderCode);

	if (response.getMessage() == InformationOrderMessage.INFORMATION_ORDER_SUCCESS
		|| response.getMessage() == InformationOrderMessage.INFORMATION_ORDER_NULL) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
    }

    @PostMapping("/add")
    public ResponseEntity<InformationOrderResponse> addInformationOrder(@RequestBody InformationOrderRequest requests) {
	InformationOrderResponse response = informationOrderService.addInformationOrder(requests);

	if (response.getStatus() == Boolean.TRUE
		&& response.getMessage() == InformationOrderMessage.INFORMATION_ORDER_SUCCESS) {
	    return new ResponseEntity<>(response, HttpStatus.CREATED);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
}
