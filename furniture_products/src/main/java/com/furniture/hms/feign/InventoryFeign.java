package com.furniture.hms.feign;

//import com.furniture.hms.ConfigLoadBalance.InventoryFeignConfiguration;
import com.furniture.hms.feign.response.InventoryResponse.InventoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "furnitureInventories",
        fallbackFactory = InventoryFeign.InventoryFeignFallBack.class)
public interface InventoryFeign {

    @GetMapping("/inventory/product/{id}")
    InventoryResponse getInventoryByProduct(@PathVariable("id") Integer id);

    @Slf4j
    @Component
    class InventoryFeignFallBack implements FallbackFactory<InventoryFeign> {

        @Override
        public InventoryFeign create(Throwable throwable) {
            return new InventoryFeign() {
                @Override
                public InventoryResponse getInventoryByProduct(Integer id) {
                    log.error("Inventory error by product id: " + throwable.getMessage());
                    return null;
                }
            };
        }
    }
}
