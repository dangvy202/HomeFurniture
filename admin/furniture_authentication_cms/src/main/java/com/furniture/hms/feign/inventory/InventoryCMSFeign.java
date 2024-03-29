package com.furniture.hms.feign.inventory;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniture.hms.dto.inventory.InventoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInventoriesAdmin", contextId = "InventoryCMSFeign", fallbackFactory = InventoryCMSFeign.InventoryCMSFeignFallBack.class)
public interface InventoryCMSFeign {

    @GetMapping("/inventory")
    ResultData<List<InventoryCMSResponse>> getAllInventories();

    @Component
    @Slf4j
    class InventoryCMSFeignFallBack implements FallbackFactory<InventoryCMSFeign> {

	@Override
	public InventoryCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
