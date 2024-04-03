package com.furniture.hms.feign.inventory;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.social.SocialCMSRequest;
import com.furniture.hms.dto.social.SocialCMSResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInventoriesAdmin", contextId = "SocialCMSFeign", fallbackFactory = SocialCMSFeign.SocialCMSFeignFallBack.class)
public interface SocialCMSFeign {

    @GetMapping("/social")
    SocialCMSResponse getSocial();

    @PutMapping("/social/update")
    ResultData<SocialCMSResponse> updateSocial(@RequestBody SocialCMSRequest request);

    @Component
    @Slf4j
    class SocialCMSFeignFallBack implements FallbackFactory<SocialCMSFeign> {

	@Override
	public SocialCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
