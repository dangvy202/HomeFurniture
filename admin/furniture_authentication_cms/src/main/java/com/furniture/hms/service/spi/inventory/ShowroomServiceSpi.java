package com.furniture.hms.service.spi.inventory;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.showroom.ShowroomCMSRequest;
import com.furniture.hms.dto.showroom.ShowroomCMSResponse;

@Component
public interface ShowroomServiceSpi {

    ShowroomCMSResponse getShowroom();

    ResultData<ShowroomCMSResponse> updateShowroom(ShowroomCMSRequest request);
}
