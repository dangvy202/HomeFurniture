package com.furniture.hms.service.spi.inventory;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.banner.BannerCMSRequest;
import com.furniture.hms.dto.banner.BannerCMSResponse;
import com.furniture.hms.dto.result.ResultData;

@Component
public interface BannerServiceSpi {

    ResultData<BannerCMSResponse> updateBanner(BannerCMSRequest request);
}
