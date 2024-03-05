package com.furniture.hms.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.furniture.hms.feign.response.ProductResponse.ProductFeignResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureProducts", fallbackFactory = ProductFeign.ProductFeignFallBack.class)
public interface ProductFeign {

    @GetMapping("/product/detail/{id}")
    ProductFeignResponse getDetailByIdProduct(@PathVariable("id") Integer id);

    @Slf4j
    @Component
    class ProductFeignFallBack implements FallbackFactory<ProductFeign> {

	@Override
	public ProductFeign create(Throwable throwable) {
	    return new ProductFeign() {
		@Override
		public ProductFeignResponse getDetailByIdProduct(Integer id) {
		    log.error("Product error by product id: " + throwable.getMessage());
		    return null;
		}
	    };
	}
    }
}
