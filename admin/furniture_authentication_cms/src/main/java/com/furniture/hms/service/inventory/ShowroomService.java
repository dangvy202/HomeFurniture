package com.furniture.hms.service.inventory;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.showroom.ShowroomCMSRequest;
import com.furniture.hms.dto.showroom.ShowroomCMSResponse;
import com.furniture.hms.feign.inventory.ShowroomCMSFeign;
import com.furniture.hms.service.spi.inventory.ShowroomServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShowroomService implements ShowroomServiceSpi {

    private final ShowroomCMSFeign showroomCMSFeign;

    @Override
    public ShowroomCMSResponse getShowroom() {
	ShowroomCMSResponse response = showroomCMSFeign.getShowroom();
	return response;
    }

    @Override
    public ResultData<ShowroomCMSResponse> updateShowroom(ShowroomCMSRequest request) {
	ResultData<ShowroomCMSResponse> response = showroomCMSFeign.updateShowroom(request);
	return response;
    }

}
