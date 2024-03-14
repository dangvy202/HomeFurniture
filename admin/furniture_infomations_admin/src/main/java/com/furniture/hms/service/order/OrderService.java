package com.furniture.hms.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.OrderDetail;
import com.furniture.hms.mapper.order.OrderMapper;
import com.furniture.hms.repository.order.OrderRepository;
import com.furniture.hms.repository.orderDetail.OrderDetailRepository;
import com.furniture.hms.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderDetailRepository orderDetailRepository;

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

//    private final ProductFeign productFeign;

    public List<OrderResponse> getAllOrder() {
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

    @Transactional
    public String deleteOrder(String idOrder) {
	List<OrderDetail> orderDetail = orderDetailRepository.findOrderDetailByOrderCode(idOrder);
	List<Order> order = orderRepository.findOrderByOrderCode(idOrder);
	if (!CollectionUtils.isEmpty(order) && !CollectionUtils.isEmpty(orderDetail)) {
	    try {
		orderRepository.deleteOrderByOrderId(order.stream().findFirst().get().getOrderCode());
		orderDetailRepository.deleteOrderByOrderId(orderDetail.stream().findFirst().get().getOrderCode());
		return OrderMessage.ORDER_SUCCESS;
	    } catch (Exception ex) {
		log.error(ex.getMessage());
		return OrderMessage.ORDER_FAIL;
	    }
	} else {
	    return OrderMessage.ORDER_FAIL;
	}
    }
}
