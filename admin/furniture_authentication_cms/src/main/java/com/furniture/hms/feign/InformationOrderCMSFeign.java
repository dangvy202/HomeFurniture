package com.furniture.hms.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniture.hms.dto.information_order.InformationOrderCMSResponse;
import com.furniture.hms.dto.result.ResultData;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInfomationsAdmin", contextId = "InformationOrderCMSFeign", fallbackFactory = InformationOrderCMSFeign.InformationOrderCMSFeignFallBack.class)
public interface InformationOrderCMSFeign {

    @GetMapping("/information-order")
    ResultData<List<InformationOrderCMSResponse>> getAllInformationOrder();

    @Component
    @Slf4j
    class InformationOrderCMSFeignFallBack implements FallbackFactory<InformationOrderCMSFeign> {

	@Override
	public InformationOrderCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
