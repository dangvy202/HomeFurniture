package com.furniture.hms.controller.inventory;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.InventoryMessage;
import com.furniture.hms.dto.inventory.InventoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.service.inventory.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/inventory")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class InventoryCMSController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<ResultData<List<InventoryCMSResponse>>> getAllInformationOrder() {
	var response = inventoryService.getAllInformationOrder();

	if (response.getMessage().equals(InventoryMessage.INVENTORY_SUCCESS) && response.getStatus() == Boolean.TRUE) {
	    return new ResponseEntity<ResultData<List<InventoryCMSResponse>>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<List<InventoryCMSResponse>>>(response, HttpStatus.NOT_FOUND);
    }

}
