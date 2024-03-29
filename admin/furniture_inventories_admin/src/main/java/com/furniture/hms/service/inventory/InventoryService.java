package com.furniture.hms.service.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.InventoryMessage;
import com.furniture.hms.dto.inventory.InventoryResponse;
import com.furniture.hms.dto.product.ProductResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.Inventory;
import com.furniture.hms.feign.ProductFeign;
import com.furniture.hms.mapper.inventory.InventoryMapper;
import com.furniture.hms.repository.inventory.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    private final ProductFeign productFeign;

    public ResultData<List<InventoryResponse>> getAllInventories() {
	List<InventoryResponse> response = new ArrayList<>();

	List<Inventory> inventoryList = inventoryRepository.findAll();

	if (!CollectionUtils.isEmpty(inventoryList)) {
	    inventoryList.forEach(inventory -> {
		ProductResponse product = new ProductResponse();
		product = productFeign.getDetailByIdProduct(inventory.getIdProduct());
		InventoryResponse inventoryRes = InventoryMapper.INSTANCE.toInventoryRes(inventory, product);
		response.add(inventoryRes);
	    });
	    return new ResultData<List<InventoryResponse>>(Boolean.TRUE, null, InventoryMessage.INVENTORY_SUCCESS,
		    response);
	}
	return new ResultData<List<InventoryResponse>>(Boolean.TRUE, null, InventoryMessage.INVENTORY_EMPTY, response);
    }
}
