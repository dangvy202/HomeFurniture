package com.furniture.hms.feign.contact;

import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSRequest;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSResponse;
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

@FeignClient(name = "furnitureContactsAdmin", contextId = "InformationContactAdminCMSFeign", fallbackFactory = InformationContactAdminCMSFeign.InformationContactAdminCMSFeignFallBack.class)
public interface InformationContactAdminCMSFeign {

    @GetMapping("/information_contact_admin")
    ResultData<List<InformationContactAdminCMSResponse>> getAllInformationContactAdmin();

    @PutMapping("/information_contact_admin/update")
    ResultData<InformationContactAdminCMSResponse> updateInformationContactAdmin(@RequestBody InformationContactAdminCMSRequest request);

    @Component
    @Slf4j
    class InformationContactAdminCMSFeignFallBack implements FallbackFactory<InformationContactAdminCMSFeign> {

        @Override
        public InformationContactAdminCMSFeign create(Throwable cause) {
            return null;
        }
    }
}
