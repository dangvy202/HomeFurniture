package com.furniture.hms.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.InformationOrderMessage;
import com.furniture.hms.dto.information_order.InformationOrderResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.InformationOrder;
import com.furniture.hms.mapper.information_order.InformationOrderMapper;
import com.furniture.hms.repository.information_order.InformationOrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationOrderService {

    private final InformationOrderRepository informationOrderRepository;

    public ResultData<List<InformationOrderResponse>> getAllInformationOrder() {
	List<InformationOrderResponse> setInformationOrderResponse = new ArrayList<>();

	List<InformationOrder> informationOrderList = informationOrderRepository.findAll();

	if (!CollectionUtils.isEmpty(informationOrderList)) {
	    informationOrderList.forEach(informationOrder -> {
		InformationOrderResponse informationOrderResponse = new InformationOrderResponse();
		InformationOrderResponse.Order orderResponse = new InformationOrderResponse.Order();

		// Map
		informationOrderResponse = InformationOrderMapper.INSTANCE.toInformationOrderRes(informationOrder);
		orderResponse = InformationOrderMapper.INSTANCE.toOrderResponse(informationOrder);

		informationOrderResponse.setOrder(orderResponse);
		setInformationOrderResponse.add(informationOrderResponse);
	    });

	    return new ResultData<List<InformationOrderResponse>>(Boolean.TRUE, null,
		    InformationOrderMessage.INFORMATION_ORDER_SUCCESS, setInformationOrderResponse);
	}

	return new ResultData<List<InformationOrderResponse>>(Boolean.FALSE,
		InformationOrderMessage.INFORMATION_ORDER_FAIL, InformationOrderMessage.INFORMATION_ORDER_FAIL,
		setInformationOrderResponse);
    }

}
