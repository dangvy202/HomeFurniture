package com.furniture.hms.service.order;

import com.furniture.hms.constant.OrderMessage;
import com.furniture.hms.dto.order.OrderRequest;
import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.User;
import com.furniture.hms.feign.ProductFeign;
import com.furniture.hms.feign.response.ProductResponse.ProductResponse;
import com.furniture.hms.mapper.order.OrderMapper;
import com.furniture.hms.repository.order.OrderRepository;
import com.furniture.hms.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ProductFeign productFeign;


    @Transactional
    public String addOrder(List<OrderRequest> requests) {
        List<Order> listOrder = new ArrayList<>();
        OrderResponse.OrderDetail listOrderResponse = new OrderResponse.OrderDetail();
        for (int i = 0 ; i < requests.size() ; i++){
            ProductResponse product = productFeign.getDetailByIdProduct(requests.get(i).getIdProduct());
            User user = userRepository.findUserByEmail(requests.get(i).getUser().getEmail());

            if (product != null && user != null) {
                Instant createDate = Instant.now();
                Instant updateDate = Instant.now();

                String orderQr = UUID.randomUUID().toString();
                Order order = OrderMapper.INSTANCE.toOrder(
                        orderQr,
                        requests.get(i).getOrderQuantity(),
                        user,
                        product.getId(),
                        createDate,
                        updateDate);
                listOrder.add(order);
            }
        }
        if(listOrder.size() != 0 ) {
            orderRepository.saveAll(listOrder);
            return OrderMessage.ORDER_SUCCESS;
        }else {
            return OrderMessage.ORDER_FAIL;
        }
    }

    public OrderResponse getOrderDetailByUser(String email) {
        List<OrderResponse.OrderDetail> listOrderDetail = new ArrayList<>();
        User user = userRepository.findUserByEmail(email);
        OrderResponse orderResponse = new OrderResponse();
        if(user != null) {
            List<Order> listOrder = orderRepository.findOrderByUser(user);
            if(listOrder.size() != 0) {
                orderResponse           = OrderMapper.INSTANCE.toOrderRes(true,null,OrderMessage.ORDER_SUCCESS);
                for (Order order : listOrder){
                    //create variable instant
                    OrderResponse.OrderDetail orderDetailResponse = new OrderResponse.OrderDetail();
                    OrderResponse.OrderDetail.Product orderProductResponse = new OrderResponse.OrderDetail.Product();
                    OrderResponse.OrderDetail.Product.Picture orderPictureResponse = new OrderResponse.OrderDetail.Product.Picture();
                    //get feign
                    ProductResponse product = productFeign.getDetailByIdProduct(order.getIdProduct());
                    //set mapping element
                    orderDetailResponse     = OrderMapper.INSTANCE.toOrderDetailRes(order);
                    orderProductResponse    = OrderMapper.INSTANCE.toOrderProductRes(product.getProductName(),product.getProductPrice(),product.getProductSaleoff());
                    orderPictureResponse    = OrderMapper.INSTANCE.toOrderPictureRes(product.getPicture().getPictureFirst());
                    //set one by one element
                    orderProductResponse.setPicture(orderPictureResponse);
                    orderDetailResponse.setProduct(orderProductResponse);
                    //Add Array
                    listOrderDetail.add(orderDetailResponse);
                }
                orderResponse.setOrderDetails(listOrderDetail);
                return orderResponse;
            }else {
                orderResponse = OrderMapper.INSTANCE.toOrderRes(true,null,OrderMessage.ORDER_EXIST);
                return orderResponse;
            }
        } else {
            orderResponse = OrderMapper.INSTANCE.toOrderRes(false,OrderMessage.ORDER_FAIL,OrderMessage.ORDER_FAIL);
            return orderResponse;
        }
    }
}
