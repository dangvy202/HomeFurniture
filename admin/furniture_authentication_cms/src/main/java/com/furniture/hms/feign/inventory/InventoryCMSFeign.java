package com.furniture.hms.feign.inventory;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.furniture.hms.dto.inventory.InventoryCMSRequest;
import com.furniture.hms.dto.inventory.InventoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInventoriesAdmin", contextId = "InventoryCMSFeign", fallbackFactory = InventoryCMSFeign.InventoryCMSFeignFallBack.class)
public interface InventoryCMSFeign {

    @GetMapping("/inventory")
    ResultData<List<InventoryCMSResponse>> getAllInventories();

    @PutMapping("/inventory/update/quantity")
    ResultData<InventoryCMSResponse> updateQuantityInventory(@RequestBody InventoryCMSRequest request);

    @PutMapping("/inventory/update/status")
    ResultData<InventoryCMSResponse> updateStatusInventory(@RequestBody InventoryCMSRequest request);

    @PostMapping("/inventory/add")
    ResultData<InventoryCMSResponse> addNewInventoryForProduct(@RequestBody InventoryCMSRequest request);

    @Component
    @Slf4j
    class InventoryCMSFeignFallBack implements FallbackFactory<InventoryCMSFeign> {

	@Override
	public InventoryCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
