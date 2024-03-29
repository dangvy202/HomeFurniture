package com.furniture.hms.service.spi.inventory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.inventory.InventoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;

@Component
public interface InventoryServiceSpi {

    ResultData<List<InventoryCMSResponse>> getAllInformationOrder();
}
