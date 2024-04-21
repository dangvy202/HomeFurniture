package com.furniture.hms.feign.contact;

import java.util.List;

import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSRequest;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSResponse;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniture.hms.dto.result.ResultData;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "furnitureContactsAdmin", contextId = "ClientSubscribeCMSFeign", fallbackFactory = ClientSubscribeCMSFeign.ClientSubscribeCMSFeignFallBack.class)
public interface ClientSubscribeCMSFeign {

    @GetMapping("/client_subscribe")
    ResultData<List<ClientSubscribeCMSResponse>> getAllClientSubscribe();

    @PutMapping("/client_subscribe/update/status")
    ResultData<ClientSubscribeCMSResponse> updateStatusClientSubscribe(@RequestBody ClientSubscribeCMSRequest request);

    @DeleteMapping("/delete")
    ResultData<ClientSubscribeCMSResponse> deleteClientSubscribe(@RequestBody ClientSubscribeCMSRequest request);
    @Component
    @Slf4j
    class ClientSubscribeCMSFeignFallBack implements FallbackFactory<ClientSubscribeCMSFeign> {

        @Override
        public ClientSubscribeCMSFeign create(Throwable cause) {
            return null;
        }
    }
}
