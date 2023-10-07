package com.furniture.hms.controller;

import com.furniture.hms.dto.product.ProductResponse;
import com.furniture.hms.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse.ProductList>> getAllProduct() {
        List<ProductResponse.ProductList> res = productService.getAllProduct();
        if(res != null){
            return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }


}
