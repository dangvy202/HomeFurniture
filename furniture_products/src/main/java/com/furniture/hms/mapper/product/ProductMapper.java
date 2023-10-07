package com.furniture.hms.mapper.product;

import com.furniture.hms.dto.product.ProductResponse;
import com.furniture.hms.entity.Product;
import com.furniture.hms.feign.response.InventoryResponse.InventoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "id" , source = "product.id")
    @Mapping(target = "productName" , source = "product.productName")
    @Mapping(target = "productDescription" , source = "product.productDescription")
    @Mapping(target = "productPrice" , source = "product.productPrice")
    @Mapping(target = "productSaleoff" , source = "product.productSaleoff")
    @Mapping(target = "productColor" , source = "product.productColor")
    @Mapping(target = "productProperty" , source = "product.productProperty")
    @Mapping(target = "productStatus" , source = "product.productStatus")
    @Mapping(target = "createBy" , source = "product.createBy")
    @Mapping(target = "createDate" , source = "product.createDate")
    @Mapping(target = "updateBy" , source = "product.updateBy")
    @Mapping(target = "updateDate" , source = "product.updateDate")
    @Mapping(target = "categoryName" , source = "product.category.categoryName")
    ProductResponse.ProductList toProductRes(Product product);

    @Mapping(target = "id" , source = "inventory.id")
    @Mapping(target = "inventoryQuantity" , source = "inventory.inventoryQuantity")
    @Mapping(target = "inventoryStatus" , source = "inventory.inventoryStatus")
    ProductResponse.ProductList.Inventory toInventoryRes(InventoryResponse inventory);


}
