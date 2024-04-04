package com.furniture.hms.service.inventory;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.banner.BannerCMSRequest;
import com.furniture.hms.dto.banner.BannerCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.inventory.BannerCMSFeign;
import com.furniture.hms.service.spi.inventory.BannerServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BannerService implements BannerServiceSpi {

    private final BannerCMSFeign bannerCMSFeign;

    @Override
    public ResultData<BannerCMSResponse> updateBanner(BannerCMSRequest request) {
	ResultData<BannerCMSResponse> response = bannerCMSFeign.updateBanner(request);
	return response;
    }
}
