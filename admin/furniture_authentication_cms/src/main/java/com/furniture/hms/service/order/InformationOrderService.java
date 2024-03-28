package com.furniture.hms.service.order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.information_order.InformationOrderCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.InformationOrderCMSFeign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationOrderService {

    private final InformationOrderCMSFeign informationOrderCMSFeign;

    public ResultData<List<InformationOrderCMSResponse>> getAllInformationOrder() {
	ResultData<List<InformationOrderCMSResponse>> response = informationOrderCMSFeign.getAllInformationOrder();
	return response;
    }

}
