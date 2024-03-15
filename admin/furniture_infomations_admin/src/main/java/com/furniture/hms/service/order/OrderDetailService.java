package com.furniture.hms.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.entity.Order;
import com.furniture.hms.mapper.order.OrderMapper;
import com.furniture.hms.repository.informationOrder.InformationOrderRepository;
import com.furniture.hms.repository.order.OrderRepository;
import com.furniture.hms.repository.orderDetail.OrderDetailRepository;
import com.furniture.hms.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    private final OrderRepository orderRepository;

    private final InformationOrderRepository informationOrderRepository;

    private final UserRepository userRepository;

//    private final ProductFeign productFeign;

    public List<OrderResponse> getOrderDetailByOrderCode(String orderCode) {
	List<OrderResponse> response = new ArrayList<>();
	List<Order> listOrder = orderRepository.findAll();
	if (!CollectionUtils.isEmpty(listOrder)) {
	    for (int i = 0; i < listOrder.size(); i++) {
		String phone = listOrder.get(i).getUser().getPhone().toString();
		response.add(OrderMapper.INSTANCE.toOrderResponse(true, null, OrderMessage.ORDER_SUCCESS,
			listOrder.get(i), phone, i + 1));
	    }
	    return response;
	} else {
	    return response;
	}
    }

}
