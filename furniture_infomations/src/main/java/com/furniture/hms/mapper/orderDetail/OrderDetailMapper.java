package com.furniture.hms.mapper.orderDetail;

import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.entity.OrderDetail;
import com.furniture.hms.entity.User;
import com.furniture.hms.enums.OrderStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.Instant;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderCode" , source = "orderCode")
    @Mapping(target = "orderQuantity" , source = "quantity")
    @Mapping(target = "user" , source = "user")
    @Mapping(target = "idProduct" , source = "idProduct")
    @Mapping(target = "createBy" , source = "user.lastName")
    @Mapping(target = "createDate" , source = "createDate")
    @Mapping(target = "updateBy" , source = "user.lastName")
    @Mapping(target = "updateDate" , source = "updateDate")
    @Mapping(target = "totalPrice" , source = "totalPrice")
    OrderDetail toOrder(String orderCode, int quantity, User user, int idProduct,
                        Instant createDate, Instant updateDate, BigDecimal totalPrice);


    @Mapping(target = "status" , source = "status")
    @Mapping(target = "error" , source = "error")
    @Mapping(target = "message" , source = "message")
    OrderResponse toOrderRes(Boolean status , String error , String message);

    @Mapping(target = "orderId" , source = "order.orderCode")
    OrderResponse.OrderDetail toOrderDetailRes(OrderDetail order);

    @Mapping(target = "productName" , source = "productName")
    @Mapping(target = "productPrice" , source = "productPrice")
    @Mapping(target = "productSaleoff" , source = "productSaleoff")
    @Mapping(target = "orderQuantity" , source = "order.orderQuantity")
    OrderResponse.OrderDetail.Product toOrderProductRes(OrderDetail order, String productName , BigDecimal productPrice , BigDecimal productSaleoff);

    @Mapping(target = "picture" , source = "picture")
    OrderResponse.OrderDetail.Product.Picture toOrderPictureRes(String picture);
}
