package com.furniture.hms.mapper.inventory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.inventory.InventoryResponse;
import com.furniture.hms.dto.product.ProductResponse;
import com.furniture.hms.entity.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    @Mapping(target = "inventoryQuantity", source = "inventory.inventoryQuantity")
    @Mapping(target = "inventoryStatus", source = "inventory.inventoryStatus")
    @Mapping(target = "createBy", source = "inventory.createBy")
    @Mapping(target = "createDate", source = "inventory.createDate")
    @Mapping(target = "updateBy", source = "inventory.updateBy")
    @Mapping(target = "updateDate", source = "inventory.updateDate")
    @Mapping(target = "product", source = "product")
    InventoryResponse toInventoryRes(Inventory inventory, ProductResponse product);

}
