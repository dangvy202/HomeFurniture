package com.furniture.hms.mapper.inventory;

import com.furniture.hms.dto.inventory.InventoryResponse;
import com.furniture.hms.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    @Mapping(target = "id" , source = "inventory.id")
    @Mapping(target = "inventoryQuantity" , source = "inventory.inventoryQuantity")
    @Mapping(target = "inventoryStatus" , source = "inventory.inventoryStatus")
    @Mapping(target = "idProduct" , source = "inventory.idProduct")
    @Mapping(target = "createBy" , source = "inventory.createBy")
    @Mapping(target = "createDate" , source = "inventory.createDate")
    @Mapping(target = "updateBy" , source = "inventory.updateBy")
    @Mapping(target = "updateDate" , source = "inventory.updateDate")
    InventoryResponse toInventoryRes(Inventory inventory);
}
