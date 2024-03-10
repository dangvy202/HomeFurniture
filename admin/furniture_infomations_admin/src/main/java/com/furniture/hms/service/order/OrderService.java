package com.furniture.hms.service.order;

import java.math.BigInteger;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderRequest;
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
	    listOrder.stream().forEach(orderDetail -> {
			String phone = orderDetail.getUser().getPhone().toString();
			response.add(OrderMapper.INSTANCE.toOrderResponse(true, null,
				OrderMessage.ORDER_SUCCESS, orderDetail,phone));
	    });
	    return response;
	} else {
	    return response;
	}
    }

//    public OrderResponse getOrderDetailByUser(String email, String orderCode) {
//	List<OrderResponse.OrderDetail> listOrderDetail = new ArrayList<>();
//	User user = userRepository.findUserByEmail(email).orElse(null);
//	OrderResponse orderResponse = new OrderResponse();
//	if (user != null) {
//	    List<OrderDetail> listOrder = orderDetailRepository.findOrderByUserAndOrderCode(user, orderCode);
//	    if (listOrder.size() != 0) {
//		orderResponse = OrderDetailMapper.INSTANCE.toOrderRes(true, null, OrderMessage.ORDER_SUCCESS);
//		for (OrderDetail order : listOrder) {
//		    // create variable instant
//		    OrderResponse.OrderDetail orderDetailResponse = new OrderResponse.OrderDetail();
//		    OrderResponse.OrderDetail.Product orderProductResponse = new OrderResponse.OrderDetail.Product();
//		    OrderResponse.OrderDetail.Product.Picture orderPictureResponse = new OrderResponse.OrderDetail.Product.Picture();
//		    // get feign
//		    ProductResponse product = productFeign.getDetailByIdProduct(order.getIdProduct());
//		    // set mapping element
//		    orderDetailResponse = OrderDetailMapper.INSTANCE.toOrderDetailRes(order);
//		    orderProductResponse = OrderDetailMapper.INSTANCE.toOrderProductRes(order, product.getProductName(),
//			    product.getProductPrice(), product.getProductSaleoff());
//		    orderPictureResponse = OrderDetailMapper.INSTANCE
//			    .toOrderPictureRes(product.getPicture().getPictureFirst());
//		    // set one by one element
//		    orderProductResponse.setPicture(orderPictureResponse);
//		    orderDetailResponse.setProduct(orderProductResponse);
//		    // Add Array
//		    listOrderDetail.add(orderDetailResponse);
//		}
//		orderResponse.setOrderDetails(listOrderDetail);
//		return orderResponse;
//	    } else {
//		orderResponse = OrderDetailMapper.INSTANCE.toOrderRes(true, null, OrderMessage.ORDER_EXIST);
//		return orderResponse;
//	    }
//	} else {
//	    orderResponse = OrderDetailMapper.INSTANCE.toOrderRes(false, OrderMessage.ORDER_FAIL,
//		    OrderMessage.ORDER_FAIL);
//	    return orderResponse;
//	}
//    }

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
