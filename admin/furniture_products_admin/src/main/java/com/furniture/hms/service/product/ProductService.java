package com.furniture.hms.service.product;

import com.furniture.hms.constant.InventoryMessage;
import com.furniture.hms.dto.product.ProductResponse;
import com.furniture.hms.entity.Product;
import com.furniture.hms.feign.InventoryFeign;
import com.furniture.hms.mapper.product.ProductMapper;
import com.furniture.hms.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final InventoryFeign inventoryFeign;

    public List<ProductResponse.ProductList> getAllProductByIdCart(List<Integer> id) {
        List<Product> listProduct = productRepository.findByIdIn(id);

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                detailResponse.setInventory(this.handleInventory(product.getId()));
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }
    public List<ProductResponse.ProductList> getAllProduct(){
        List<Product> listProduct = productRepository.findAll();

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                detailResponse.setInventory(this.handleInventory(product.getId()));
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }

    public List<ProductResponse.ProductList> getProductByRoom(int idRoom){
        List<Product> listProduct = productRepository.findByRoom(idRoom);

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                detailResponse.setInventory(this.handleInventory(product.getId()));
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }

    public List<ProductResponse.ProductList> getProductByCategory(int idCategory){
        List<Product> listProduct = productRepository.findByCategory(idCategory);

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                detailResponse.setInventory(this.handleInventory(product.getId()));
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }

    public List<ProductResponse.ProductList> getProductByCategoryRedirect(String categoryRedirect) {
        List<Product> listProduct = productRepository.findProductByCategoryRedirect(categoryRedirect);

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                detailResponse.setInventory(this.handleInventory(product.getId()));
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }

    public List<ProductResponse.ProductList> getProductByRoomRedirect(String roomRedirect) {
        List<Product> listProduct = productRepository.findProductByRoomRedirect(roomRedirect);

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                detailResponse.setInventory(this.handleInventory(product.getId()));
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }

    public List<ProductResponse.ProductList> search(String nameProduct){
        List<Product> listProduct = productRepository.findByProductNameContaining(nameProduct);

        List<ProductResponse.ProductList> listProductResponse = new ArrayList<>();

        if(!listProduct.isEmpty()) {
            for (Product product : listProduct){
                ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
                detailResponse.setInventory(this.handleInventory(product.getId()));
                listProductResponse.add(detailResponse);
            }
            return listProductResponse;
        }else {
            return null;
        }
    }

    public ProductResponse.ProductList getDetailByIdProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null) {
            ProductResponse.ProductList detailResponse = ProductMapper.INSTANCE.toProductRes(product);
            detailResponse.setInventory(this.handleInventory(id));
            return detailResponse;
        }
        return null;
    }

    public ProductResponse.ProductList.Inventory handleInventory(int id) {
        ProductResponse.ProductList.Inventory.Message message = new ProductResponse.ProductList.Inventory.Message();
        ProductResponse.ProductList.Inventory inventoryResponse = new ProductResponse.ProductList.Inventory();
        try{
            inventoryResponse = ProductMapper.INSTANCE.toInventoryRes(inventoryFeign.getInventoryByProduct(id));
            if (inventoryResponse.getInventoryQuantity() > 0 && inventoryResponse.getInventoryStatus() == 1){
                message = ProductMapper.INSTANCE.toMessageRes(true,null, InventoryMessage.AVAILABLE);
            }else if(inventoryResponse.getInventoryQuantity() == 0 && inventoryResponse.getInventoryStatus() == 1){
                message = ProductMapper.INSTANCE.toMessageRes(true,null, InventoryMessage.INAVAILABLE);
            }else if (inventoryResponse.getInventoryStatus() == 0) {
                message = ProductMapper.INSTANCE.toMessageRes(true,null, InventoryMessage.INAVAILABLE);
            }else {
                message = ProductMapper.INSTANCE.toMessageRes(false,"404", InventoryMessage.ERROR);
            }
            inventoryResponse.setMessage(message);
            return inventoryResponse;
        }catch (Exception ex){
            message = ProductMapper.INSTANCE.toMessageRes(false,"404", InventoryMessage.ERROR);
            log.error(ex.getMessage());
            inventoryResponse.setMessage(message);
            return inventoryResponse;
        }
    }

}
