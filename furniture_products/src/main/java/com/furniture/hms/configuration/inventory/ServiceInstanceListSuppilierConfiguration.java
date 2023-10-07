//package com.furniture.hms.configuration.inventory;
//
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.DefaultServiceInstance;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.cloud.netflix.eureka.EurekaServiceInstance;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//
//public class ServiceInstanceListSuppilierConfiguration implements ServiceInstanceListSupplier {
//    private String service;
//
//    @Override
//    public String getServiceId() {
//        return service;
//    }
//
//    @Override
//    public Flux<List<ServiceInstance>> get() {
//        return Flux.just(Arrays
//                .asList(new DefaultServiceInstance(service + "1", EurekaServiceInstance.getServiceId(), "localhost", eurekaServiceInstance.getPort(), false)));
//    }
//}
