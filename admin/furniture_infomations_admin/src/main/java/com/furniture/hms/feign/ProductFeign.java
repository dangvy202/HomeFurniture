package com.furniture.hms.feign;

import com.furniture.hms.feign.response.ProductResponse.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "furnitureProducts" , fallbackFactory = ProductFeign.ProductFeignFallBack.class)
public interface ProductFeign {

    @GetMapping("/product/detail/{id}")
    ProductResponse getDetailByIdProduct(@PathVariable("id") Integer id);

    @Component
    @Slf4j
    class ProductFeignFallBack implements FallbackFactory<ProductFeign> {

        @Override
        public ProductFeign create(Throwable cause) {
            log.error("Inventory error by product id: " + cause.getMessage());
            return null;
        }
    }
}
