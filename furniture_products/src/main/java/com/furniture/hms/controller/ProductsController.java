package com.furniture.hms.controller;

import com.furniture.hms.dto.product.ProductResponse;
import com.furniture.hms.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse.ProductList>> getAllProduct() {
        List<ProductResponse.ProductList> response = productService.getAllProduct();
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductResponse.ProductList>> getProductByCategory(@PathVariable("id") Integer id){
        List<ProductResponse.ProductList> response = productService.getProductByCategory(id);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category-redirect/{categoryRedirect}")
    public ResponseEntity<List<ProductResponse.ProductList>> getProductByCategoryRedirect(@PathVariable("categoryRedirect") String categoryRedirect) {
        List<ProductResponse.ProductList> response = productService.getProductByCategoryRedirect(categoryRedirect);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/room-redirect/{roomRedirect}")
    public ResponseEntity<List<ProductResponse.ProductList>> getProductByRoomRedirect(@PathVariable("roomRedirect") String roomRedirect) {
        List<ProductResponse.ProductList> response = productService.getProductByRoomRedirect(roomRedirect);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<List<ProductResponse.ProductList>> getProductByRoom(@PathVariable("id") Integer id){
        List<ProductResponse.ProductList> response = productService.getProductByRoom(id);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<ProductResponse.ProductList> getDetailByIdProduct(@PathVariable("id") Integer id){
        ProductResponse.ProductList response = productService.getDetailByIdProduct(id);
        if(response != null) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/{productName}")
    public ResponseEntity<List<ProductResponse.ProductList>> search(@PathVariable("productName") String productName){
        List<ProductResponse.ProductList> response = productService.search(productName);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
