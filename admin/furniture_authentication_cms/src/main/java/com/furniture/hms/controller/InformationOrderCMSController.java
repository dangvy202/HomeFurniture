package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.InformationOrderMessage;
import com.furniture.hms.dto.information_order.InformationOrderCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.service.order.InformationOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/information-order")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class InformationOrderCMSController {

    private final InformationOrderService informationOrderService;

    @GetMapping
    public ResponseEntity<ResultData<List<InformationOrderCMSResponse>>> getAllInformationOrder() {
	var response = informationOrderService.getAllInformationOrder();

	if (response.getMessage() == InformationOrderMessage.INFORMATION_ORDER_SUCCESS
		&& response.getStatus() == Boolean.TRUE) {
	    return new ResponseEntity<ResultData<List<InformationOrderCMSResponse>>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<List<InformationOrderCMSResponse>>>(response, HttpStatus.NOT_FOUND);
    }

}
