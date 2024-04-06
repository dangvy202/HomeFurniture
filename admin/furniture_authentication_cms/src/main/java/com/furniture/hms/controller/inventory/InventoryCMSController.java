package com.furniture.hms.controller.inventory;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.furniture.hms.constant.InventoryMessage;
import com.furniture.hms.dto.inventory.InventoryCMSRequest;
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
    public ResponseEntity<ResultData<List<InventoryCMSResponse>>> getAllInventory() {
	var response = inventoryService.getAllInformationOrder();

	if (response.getMessage().equals(InventoryMessage.INVENTORY_SUCCESS) && response.getStatus() == Boolean.TRUE) {
	    return new ResponseEntity<ResultData<List<InventoryCMSResponse>>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<List<InventoryCMSResponse>>>(response, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/quantity")
    public ResponseEntity<ResultData<InventoryCMSResponse>> updateQuantityInventory(
	    @RequestBody InventoryCMSRequest request) {
	var response = inventoryService.updateQuantityInventory(request);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(InventoryMessage.INVENTORY_SUCCESS)) {
	    return new ResponseEntity<ResultData<InventoryCMSResponse>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<InventoryCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

	@PutMapping("/update/status")
	public ResponseEntity<ResultData<InventoryCMSResponse>> updateStatusInventory(
			@RequestBody InventoryCMSRequest request) {
		var response = inventoryService.updateStatusInventory(request);

		if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(InventoryMessage.INVENTORY_SUCCESS)) {
			return new ResponseEntity<ResultData<InventoryCMSResponse>>(response, HttpStatus.OK);
		}

		return new ResponseEntity<ResultData<InventoryCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/add")
	public ResponseEntity<ResultData<InventoryCMSResponse>> addNewInventoryForProduct(
			@RequestBody InventoryCMSRequest request) {
		var response = inventoryService.addNewInventoryForProduct(request);

		if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(InventoryMessage.INVENTORY_SUCCESS)) {
			return new ResponseEntity<ResultData<InventoryCMSResponse>>(response, HttpStatus.OK);
		}

		return new ResponseEntity<ResultData<InventoryCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
