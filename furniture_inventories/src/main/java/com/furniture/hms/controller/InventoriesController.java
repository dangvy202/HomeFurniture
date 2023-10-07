package com.furniture.hms.controller;

import com.furniture.hms.dto.inventory.InventoryResponse;
import com.furniture.hms.service.inventory.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoriesController {

    private final InventoryService inventoryService;

    @GetMapping("/product/{id}")
    public ResponseEntity<InventoryResponse> getInventoryByProduct(@PathVariable("id") Integer id) {
        InventoryResponse response = inventoryService.getInventoryByProductId(id);
        if (response != null ){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    
}
