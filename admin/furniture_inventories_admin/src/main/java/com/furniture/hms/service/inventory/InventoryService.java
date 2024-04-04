package com.furniture.hms.service.inventory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.InventoryMessage;
import com.furniture.hms.dto.inventory.InventoryRequest;
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

    public ResultData<InventoryResponse> updateQuantityInventory(InventoryRequest request) {

	InventoryResponse response = new InventoryResponse();
	ProductResponse product = new ProductResponse();

	Inventory inventory = inventoryRepository.findById(request.getId()).orElse(null);

	if (inventory != null) {
	    product = productFeign.getDetailByIdProduct(inventory.getIdProduct());
	    inventory.setInventoryQuantity(request.getInventoryQuantity());
	    inventoryRepository.save(inventory);
	    response = InventoryMapper.INSTANCE.toInventoryRes(inventory, product);
	    return new ResultData<InventoryResponse>(Boolean.TRUE, null, InventoryMessage.INVENTORY_SUCCESS, response);
	}
	return new ResultData<InventoryResponse>(Boolean.FALSE, InventoryMessage.INVENTORY_FAIL,
		InventoryMessage.INVENTORY_EXIST, response);
    }

    public ResultData<InventoryResponse> updateStatusInventory(InventoryRequest request) {

	InventoryResponse response = new InventoryResponse();
	ProductResponse product = new ProductResponse();

	Inventory inventory = inventoryRepository.findById(request.getId()).orElse(null);

	if (inventory != null) {
	    product = productFeign.getDetailByIdProduct(inventory.getIdProduct());
	    inventory.setInventoryStatus(request.getInventoryStatus());
	    inventoryRepository.save(inventory);
	    response = InventoryMapper.INSTANCE.toInventoryRes(inventory, product);
	    return new ResultData<InventoryResponse>(Boolean.TRUE, null, InventoryMessage.INVENTORY_SUCCESS, response);
	}
	return new ResultData<InventoryResponse>(Boolean.FALSE, InventoryMessage.INVENTORY_FAIL,
		InventoryMessage.INVENTORY_EXIST, response);
    }

    public ResultData<InventoryResponse> addNewInventoryForProduct(InventoryRequest request) {
	Inventory inventory = new Inventory();
	ProductResponse product = new ProductResponse();
	InventoryResponse response = new InventoryResponse();

	Inventory checkProductIsExist = inventoryRepository.findByIdProduct(request.getIdProduct()).orElse(null);

	if (checkProductIsExist == null) {
	    request.setCreateBy("Vy");
	    request.setCreateDate(new Date());
	    request.setUpdateBy("Vy");
	    request.setUpdateDate(new Date());

	    inventory = InventoryMapper.INSTANCE.toInventory(request);
	    inventoryRepository.save(inventory);
	    product = productFeign.getDetailByIdProduct(request.getIdProduct());
	    response = InventoryMapper.INSTANCE.toInventoryRes(inventory, product);
	    return new ResultData<InventoryResponse>(Boolean.TRUE, null, InventoryMessage.INVENTORY_SUCCESS, response);
	}

	return new ResultData<InventoryResponse>(Boolean.FALSE, InventoryMessage.INVENTORY_EXIST,
		InventoryMessage.INVENTORY_EXIST, response);
    }
}
