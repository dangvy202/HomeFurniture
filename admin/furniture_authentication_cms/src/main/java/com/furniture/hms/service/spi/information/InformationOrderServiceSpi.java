package com.furniture.hms.service.spi.information;

import java.util.List;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.information_order.InformationOrderCMSResponse;
import com.furniture.hms.dto.result.ResultData;

@Component
public interface InformationOrderServiceSpi {

    ResultData<List<InformationOrderCMSResponse>> getAllInformationOrder();
}
