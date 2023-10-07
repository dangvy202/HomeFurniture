package com.furniture.hms.service.inventory;

import com.furniture.hms.dto.inventory.InventoryResponse;
import com.furniture.hms.entity.Inventory;
import com.furniture.hms.mapper.inventory.InventoryMapper;
import com.furniture.hms.repository.inventory.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public InventoryResponse getInventoryByProductId(Integer productId) {
        try{
            Inventory inventory = inventoryRepository.findByIdProduct(productId);
            InventoryResponse response = InventoryMapper.INSTANCE.toInventoryRes(inventory);
            return response;
        }catch (NullPointerException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
