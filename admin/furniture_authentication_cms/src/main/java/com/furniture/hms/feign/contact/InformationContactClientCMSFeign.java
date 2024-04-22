package com.furniture.hms.feign.contact;

import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "furnitureContactsAdmin", contextId = "InformationContactClientCMSFeign", fallbackFactory = InformationContactClientCMSFeign.InformationContactClientCMSFeignFallBack.class)
public interface InformationContactClientCMSFeign {

    @GetMapping("/information_contact_client")
    ResultData<List<InformationContactClientCMSResponse>> getAllInformationContactClient();

    @PutMapping("/information_contact_client/update/status")
    ResultData<InformationContactClientCMSResponse> updateStatusWhenHaveContact (@RequestBody InformationContactClientCMSRequest request);


        @Component
    @Slf4j
    class InformationContactClientCMSFeignFallBack implements FallbackFactory<InformationContactClientCMSFeign> {
        @Override
        public InformationContactClientCMSFeign create(Throwable cause) {
            return null;
        }
    }
}
