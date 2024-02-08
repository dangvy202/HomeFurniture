package com.furniture.hms.service.informationOrder;

import java.math.BigDecimal;
import java.time.Instant;

import org.springframework.stereotype.Service;

import com.furniture.hms.constant.InformationOrderMessage;
import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.informationOrder.InformationOrderRequest;
import com.furniture.hms.dto.informationOrder.InformationOrderResponse;
import com.furniture.hms.entity.InformationOrder;
import com.furniture.hms.entity.Order;
import com.furniture.hms.mapper.informationOrder.InformationOrderMapper;
import com.furniture.hms.repository.informationOrder.InformationOrderRepository;
import com.furniture.hms.repository.order.OrderRepository;
import com.furniture.hms.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationOrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final InformationOrderRepository informationOrderRepository;

	public InformationOrderResponse getInformationOrderByOrderCode(String code) {
		InformationOrderResponse response = new InformationOrderResponse();

		Order order = orderRepository.findOrderByOrderCode(code).orElse(null);

		if(order != null) {
			InformationOrder informationOrder = informationOrderRepository.findInformationOrderByIdOrder(order.getId()).orElse(null);
			if(informationOrder != null) {
				response.setError(null);
				response.setMessage(InformationOrderMessage.INFORMATION_ORDER_SUCCESS);
				response.setStatus(true);
				response.setInformationOrderDetail(InformationOrderMapper.INSTANCE.toInformationOrderDetail(
						informationOrder.getAddress(), informationOrder.getEmail(), informationOrder.getPhone().toString(),
						informationOrder.getUserName()));
				return response;
			} else {
				response.setError(null);
				response.setMessage(InformationOrderMessage.INFORMATION_ORDER_NULL);
				response.setStatus(true);
				return response;
			}
		} else {
			response.setError(InformationOrderMessage.INFORMATION_ORDER_FAIL);
			response.setMessage(OrderMessage.ORDER_EXIST);
			response.setStatus(false);
			return response;
		}
	}

    public InformationOrderResponse addInformationOrder(InformationOrderRequest request) {
	Order order = orderRepository.findOrderByOrderCode(request.getOrderCode()).orElse(null);

	InformationOrderResponse response = new InformationOrderResponse();
	if (order != null) {
	    BigDecimal phone = BigDecimal.valueOf(Long.parseLong(request.getPhone()));
	    Instant dateNow = Instant.now();

	    InformationOrder informationOrder = InformationOrderMapper.INSTANCE.toInformationOrderEntity(
		    request.getUserName(), request.getEmail(), request.getAddress(), phone, order,
		    request.getUserName(), dateNow, request.getUserName(), dateNow);
	    try {
		informationOrderRepository.save(informationOrder);
		response.setError(null);
		response.setMessage(InformationOrderMessage.INFORMATION_ORDER_SUCCESS);
		response.setStatus(true);
		response.setInformationOrderDetail(InformationOrderMapper.INSTANCE.toInformationOrderDetail(
			request.getAddress(), request.getEmail(), request.getPhone(), request.getUserName()));
		return response;
	    } catch (Exception ex) {
		response.setError(InformationOrderMessage.INFORMATION_ORDER_EXIST);
		response.setMessage(InformationOrderMessage.INFORMATION_ORDER_FAIL);
		response.setStatus(false);
		return response;
	    }
	} else {
	    response.setError(InformationOrderMessage.INFORMATION_ORDER_FAIL);
	    response.setMessage(OrderMessage.ORDER_EXIST);
	    response.setStatus(false);
	    return response;
	}
    }

}
