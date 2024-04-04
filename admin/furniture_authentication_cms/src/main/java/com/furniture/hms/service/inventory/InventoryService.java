package com.furniture.hms.service.inventory;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.inventory.InventoryCMSRequest;
import com.furniture.hms.dto.inventory.InventoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.inventory.InventoryCMSFeign;
import com.furniture.hms.service.spi.inventory.InventoryServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService implements InventoryServiceSpi {

    private final InventoryCMSFeign inventoryCMSFeign;

    @Override
    public ResultData<List<InventoryCMSResponse>> getAllInformationOrder() {
	ResultData<List<InventoryCMSResponse>> response = inventoryCMSFeign.getAllInventories();
	return response;
    }

    @Override
    public ResultData<InventoryCMSResponse> updateQuantityInventory(InventoryCMSRequest request) {
	ResultData<InventoryCMSResponse> response = inventoryCMSFeign.updateQuantityInventory(request);
	return response;
    }

}
