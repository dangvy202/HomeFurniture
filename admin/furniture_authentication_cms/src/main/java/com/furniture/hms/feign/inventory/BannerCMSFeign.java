package com.furniture.hms.feign.inventory;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.furniture.hms.dto.banner.BannerCMSRequest;
import com.furniture.hms.dto.banner.BannerCMSResponse;
import com.furniture.hms.dto.result.ResultData;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInventoriesAdmin", contextId = "BannerCMSFeign", fallbackFactory = BannerCMSFeign.BannerCMSFeignFallBack.class)
public interface BannerCMSFeign {

    @PostMapping("/banner/update")
    ResultData<BannerCMSResponse> updateBanner(@ModelAttribute @Validated BannerCMSRequest request);

    @Component
    @Slf4j
    class BannerCMSFeignFallBack implements FallbackFactory<BannerCMSFeign> {

	@Override
	public BannerCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
