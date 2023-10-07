package com.furniture.hms.service.product;

import com.furniture.hms.dto.product.ProductResponse;
import com.furniture.hms.entity.Product;
//import com.furniture.hms.feign.InventoryFeign;
import com.furniture.hms.feign.InventoryFeign;
import com.furniture.hms.feign.response.InventoryResponse.InventoryResponse;
import com.furniture.hms.mapper.product.ProductMapper;
import com.furniture.hms.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryFeign inventoryFeign;



    public List<ProductResponse.ProductList> getAllProduct(){
        List<Product> listProduct = productRepository.findAll();

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                ProductResponse.ProductList.Inventory inventoryResponse = ProductMapper.INSTANCE.toInventoryRes(inventoryFeign.getInventoryByProduct(product.getId()));
                detailResponse.setInventory(inventoryResponse);
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }
}
