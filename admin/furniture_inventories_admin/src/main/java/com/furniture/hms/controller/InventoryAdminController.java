package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.inventory.InventoryResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.inventory.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryAdminController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<ResultData<List<InventoryResponse>>> getAllInventories() {
	var response = inventoryService.getAllInventories();
	return new ResponseEntity<ResultData<List<InventoryResponse>>>(response, HttpStatus.OK);
    }

}
