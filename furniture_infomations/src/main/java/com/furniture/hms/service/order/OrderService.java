package com.furniture.hms.service.order;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderRequest;
import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.OrderDetail;
import com.furniture.hms.entity.User;
import com.furniture.hms.enums.OrderStatusEnum;
import com.furniture.hms.feign.ProductFeign;
import com.furniture.hms.feign.response.ProductResponse.ProductResponse;
import com.furniture.hms.mapper.order.OrderMapper;
import com.furniture.hms.mapper.orderDetail.OrderDetailMapper;
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

    private final ProductFeign productFeign;

    @Transactional
    public OrderResponse addOrder(List<OrderRequest> requests) {
	List<OrderDetail> listOrder = new ArrayList<>();
	OrderResponse response = new OrderResponse();
	String orderQr = UUID.randomUUID().toString();
	User user = new User();

	Instant createDate = Instant.now();
	Instant updateDate = Instant.now();

	BigDecimal totalOrder = BigDecimal.ZERO;

	for (OrderRequest orderRequest : requests) {
	    ProductResponse product = productFeign.getDetailByIdProduct(orderRequest.getIdProduct());
	    user = userRepository.findUserByEmail(orderRequest.getUser().getEmail());

	    if (product != null && user != null) {
			OrderDetail order = OrderDetailMapper.INSTANCE.toOrder(OrderStatusEnum.UNPAID, orderQr,
				orderRequest.getOrderQuantity(), user, product.getId(), createDate, updateDate,
				orderRequest.getTotalPrice());
			totalOrder = totalOrder.add(orderRequest.getTotalPrice());
			listOrder.add(order);
	    }
	}
	if (listOrder.size() != 0) {
	    Order order = OrderMapper.INSTANCE.toOrderEntity(user.getUserName(), createDate, orderQr,
		    OrderStatusEnum.UNPAID, user.getUserName(), updateDate, user, totalOrder);
	    orderRepository.save(order);
	    orderDetailRepository.saveAll(listOrder);
		response.setError(null);
		response.setMessage(OrderMessage.ORDER_SUCCESS);
		response.setStatus(true);
		response.setOrderCode(orderQr);
	    return response;
	} else {
		response.setError(OrderMessage.ORDER_FAIL);
		response.setMessage(OrderMessage.ORDER_FAIL);
		response.setStatus(false);
	    return response;
	}
    }

    public OrderResponse getOrderDetailByUser(String email) {
	List<OrderResponse.OrderDetail> listOrderDetail = new ArrayList<>();
	User user = userRepository.findUserByEmail(email);
	OrderResponse orderResponse = new OrderResponse();
	if (user != null) {
	    List<OrderDetail> listOrder = orderDetailRepository.findOrderByUser(user);
	    if (listOrder.size() != 0) {
		orderResponse = OrderDetailMapper.INSTANCE.toOrderRes(true, null, OrderMessage.ORDER_SUCCESS);
		for (OrderDetail order : listOrder) {
		    // create variable instant
		    OrderResponse.OrderDetail orderDetailResponse = new OrderResponse.OrderDetail();
		    OrderResponse.OrderDetail.Product orderProductResponse = new OrderResponse.OrderDetail.Product();
		    OrderResponse.OrderDetail.Product.Picture orderPictureResponse = new OrderResponse.OrderDetail.Product.Picture();
		    // get feign
		    ProductResponse product = productFeign.getDetailByIdProduct(order.getIdProduct());
		    // set mapping element
		    orderDetailResponse = OrderDetailMapper.INSTANCE.toOrderDetailRes(order);
		    orderProductResponse = OrderDetailMapper.INSTANCE.toOrderProductRes(product.getProductName(),
			    product.getProductPrice(), product.getProductSaleoff());
		    orderPictureResponse = OrderDetailMapper.INSTANCE
			    .toOrderPictureRes(product.getPicture().getPictureFirst());
		    // set one by one element
		    orderProductResponse.setPicture(orderPictureResponse);
		    orderDetailResponse.setProduct(orderProductResponse);
		    // Add Array
		    listOrderDetail.add(orderDetailResponse);
		}
		orderResponse.setOrderDetails(listOrderDetail);
		return orderResponse;
	    } else {
		orderResponse = OrderDetailMapper.INSTANCE.toOrderRes(true, null, OrderMessage.ORDER_EXIST);
		return orderResponse;
	    }
	} else {
	    orderResponse = OrderDetailMapper.INSTANCE.toOrderRes(false, OrderMessage.ORDER_FAIL,
		    OrderMessage.ORDER_FAIL);
	    return orderResponse;
	}
    }

    public String updateOrder(String idOrder, OrderRequest request) {
	OrderDetail order = orderDetailRepository.findOrderByOrderCode(idOrder);
	Instant createDate = Instant.now();
	Instant updateDate = Instant.now();
	int id = order.getId();
	if (order != null) {
//            order = OrderDetailMapper.INSTANCE.toOrder(
//                    OrderStatusEnum.UNPAID,
//                    order.getOrderCode(),
//                    request.getOrderQuantity(),
//                    order.getUser(),
//                    request.getIdProduct(),
//                    createDate,
//                    updateDate);
//            order.setId(id);
	    try {
		orderDetailRepository.save(order);
		return OrderMessage.ORDER_SUCCESS;
	    } catch (Exception ex) {
		log.error(ex.getMessage());
		return OrderMessage.ORDER_FAIL;
	    }
	} else {
	    return OrderMessage.ORDER_FAIL;
	}
    }

    public String deleteOrder(String idOrder) {
	OrderDetail order = orderDetailRepository.findOrderByOrderCode(idOrder);
	if (order != null) {
	    try {
		orderDetailRepository.deleteOrderByOrderId(order.getOrderCode());
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
