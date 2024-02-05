package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.InformationOrderMessage;
import com.furniture.hms.dto.informationOrder.InformationOrderRequest;
import com.furniture.hms.dto.informationOrder.InformationOrderResponse;
import com.furniture.hms.service.informationOrder.InformationOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/information-order")
@RequiredArgsConstructor
public class InformationOrderController {

    private final InformationOrderService informationOrderService;

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
