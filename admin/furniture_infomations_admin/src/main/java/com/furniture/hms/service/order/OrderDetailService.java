package com.furniture.hms.service.order;

import java.util.ArrayList;
import java.util.List;

import com.furniture.hms.entity.OrderDetail;
import com.furniture.hms.entity.User;
import com.furniture.hms.feign.ProductFeign;
import com.furniture.hms.feign.response.ProductResponse.ProductResponse;
import com.furniture.hms.mapper.orderDetail.OrderDetailMapper;
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

    private final ProductFeign productFeign;

    public OrderResponse getOrderDetailByOrderCode(String orderCode) {

		List<OrderResponse.OrderDetail> orderDetailListResponse = new ArrayList<>();
		List<OrderDetail> orderDetailList = orderDetailRepository.findOrderDetailByOrderCode(orderCode);

		OrderResponse orderResponse = new OrderResponse();

		if(!CollectionUtils.isEmpty(orderDetailList)) {
			User user = userRepository.findById(orderDetailList.stream().findFirst().get().getUser().getId()).orElse(null);
			if(user != null) {
				orderDetailList.forEach(orderDetail -> {
					// create variable instant
					OrderResponse.OrderDetail orderDetailResponse = new OrderResponse.OrderDetail();
					OrderResponse.OrderDetail.Product orderProductResponse = new OrderResponse.OrderDetail.Product();
					OrderResponse.OrderDetail.Product.Picture orderPictureResponse = new OrderResponse.OrderDetail.Product.Picture();
					// get feign
					ProductResponse product = productFeign.getDetailByIdProduct(orderDetail.getIdProduct());
					// set mapping element
					orderDetailResponse = OrderDetailMapper.INSTANCE.toOrderDetailRes(orderDetail);
					orderProductResponse = OrderDetailMapper.INSTANCE.toOrderProductRes(orderDetail, product.getProductName(),
							product.getProductPrice(), product.getProductSaleoff());
					orderPictureResponse = OrderDetailMapper.INSTANCE
							.toOrderPictureRes(product.getPicture().getPictureFirst());
					// set one by one element
					orderProductResponse.setPicture(orderPictureResponse);
					orderDetailResponse.setProduct(orderProductResponse);
					// Add Array
					orderDetailListResponse.add(orderDetailResponse);
				});
				orderResponse.setStatus(Boolean.TRUE);
				orderResponse.setEmail(null);
				orderResponse.setMessage(OrderMessage.ORDER_SUCCESS);
				orderResponse.setOrderCode(orderCode);
				orderResponse.setUserName(user.getUserName());
				orderResponse.setPhone(user.getPhone().toString());
				orderResponse.setEmail(user.getEmail());
				orderResponse.setOrderDetails(orderDetailListResponse);
				return orderResponse;
			}

		}
		orderResponse = OrderDetailMapper.INSTANCE.toOrderRes(false, OrderMessage.ORDER_FAIL,
				OrderMessage.ORDER_FAIL);
		return orderResponse;
    }

}
