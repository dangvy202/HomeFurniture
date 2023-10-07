package com.furniture.hms.configuration;

//import com.furniture.hms.configuration.inventory.InventoryFeignConfiguration;
import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@LoadBalancerClient(name = "furnitureInventories")// , configuration = InventoryFeignConfiguration.class)
public class ConfigLoadBalance {

    @LoadBalanced
    @Bean
    public Feign.Builder contractFeign(){
        return Feign.builder();
    }
}
