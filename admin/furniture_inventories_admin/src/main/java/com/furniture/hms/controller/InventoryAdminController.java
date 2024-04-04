package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.inventory.InventoryRequest;
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

    @PutMapping("/update/quantity")
    public ResponseEntity<ResultData<InventoryResponse>> updateQuantityInventory(
	    @RequestBody InventoryRequest request) {
	var response = inventoryService.updateQuantityInventory(request);
	return new ResponseEntity<ResultData<InventoryResponse>>(response, HttpStatus.OK);
    }

    @PutMapping("/update/status")
    public ResponseEntity<ResultData<InventoryResponse>> updateStatusInventory(@RequestBody InventoryRequest request) {
	var response = inventoryService.updateStatusInventory(request);
	return new ResponseEntity<ResultData<InventoryResponse>>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResultData<InventoryResponse>> addNewInventoryForProduct(
	    @RequestBody InventoryRequest request) {
	var response = inventoryService.addNewInventoryForProduct(request);
	return new ResponseEntity<ResultData<InventoryResponse>>(response, HttpStatus.OK);
    }
}
