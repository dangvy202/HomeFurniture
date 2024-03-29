package com.furniture.hms.feign.inventory;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.showroom.ShowroomCMSRequest;
import com.furniture.hms.dto.showroom.ShowroomCMSResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInventoriesAdmin", contextId = "ShowroomCMSFeign", fallbackFactory = ShowroomCMSFeign.ShowroomCMSFeignFallBack.class)
public interface ShowroomCMSFeign {

    @GetMapping("/showroom")
    ShowroomCMSResponse getShowroom();

    @PutMapping("/showroom/update")
    ResultData<ShowroomCMSResponse> updateShowroom(@RequestBody ShowroomCMSRequest request);

    @Component
    @Slf4j
    class ShowroomCMSFeignFallBack implements FallbackFactory<ShowroomCMSFeign> {

	@Override
	public ShowroomCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
