package com.furniture.hms.feign.contact;

import java.util.List;

import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSRequest;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSResponse;
import com.furniture.hms.dto.contact_history.ContactHistoryCMSRequest;
import com.furniture.hms.dto.contact_history.ContactHistoryCMSResponse;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniture.hms.dto.result.ResultData;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "furnitureContactsAdmin", contextId = "ContactClientCMSFeign", fallbackFactory = ContactClientCMSFeign.ContactClientCMSFeignFallBack.class)
public interface ContactClientCMSFeign {

    @GetMapping("/contact_client")
    ResultData<List<ContactHistoryCMSResponse>> getAllContactClient();

    @PutMapping("/contact_client/update/process")
    ResultData<ContactHistoryCMSResponse> updateProcess(@RequestBody ContactHistoryCMSRequest request);

    @DeleteMapping("/contact_client/delete")
    ResultData<ContactHistoryCMSResponse> deleteByProcess(@RequestBody ContactHistoryCMSRequest request);
    @Component
    @Slf4j
    class ContactClientCMSFeignFallBack implements FallbackFactory<ContactClientCMSFeign> {

        @Override
        public ContactClientCMSFeign create(Throwable cause) {
            return null;
        }
    }
}
