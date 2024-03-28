package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.information_order.InformationOrderResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.order.InformationOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/information-order")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class InformationOrderAdminController {

    private final InformationOrderService informationOrderService;

    @GetMapping
    public ResponseEntity<ResultData<List<InformationOrderResponse>>> getAllInformationOrder() {
	var response = informationOrderService.getAllInformationOrder();
	return new ResponseEntity<ResultData<List<InformationOrderResponse>>>(response, HttpStatus.OK);
    }

}
