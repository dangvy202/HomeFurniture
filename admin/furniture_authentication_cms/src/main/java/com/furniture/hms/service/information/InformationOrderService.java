package com.furniture.hms.service.information;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.information_order.InformationOrderCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.information.InformationOrderCMSFeign;
import com.furniture.hms.service.spi.information.InformationOrderServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationOrderService implements InformationOrderServiceSpi {

    private final InformationOrderCMSFeign informationOrderCMSFeign;

    @Override
    public ResultData<List<InformationOrderCMSResponse>> getAllInformationOrder() {
	ResultData<List<InformationOrderCMSResponse>> response = informationOrderCMSFeign.getAllInformationOrder();
	return response;
    }

}
