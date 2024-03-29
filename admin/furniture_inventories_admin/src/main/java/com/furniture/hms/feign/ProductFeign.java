package com.furniture.hms.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.furniture.hms.dto.product.ProductResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureProducts", contextId = "ProductFeign", fallbackFactory = ProductFeign.ProductFeignFallBack.class)
public interface ProductFeign {

    @GetMapping("/product/detail/{id}")
    ProductResponse getDetailByIdProduct(@PathVariable("id") Integer id);

    @Component
    @Slf4j
    class ProductFeignFallBack implements FallbackFactory<ProductFeign> {

	@Override
	public ProductFeign create(Throwable cause) {
	    return null;
	}
    }
}
