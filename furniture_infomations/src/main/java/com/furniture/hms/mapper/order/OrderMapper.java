package com.furniture.hms.mapper.order;

import java.math.BigDecimal;
import java.time.Instant;

import com.furniture.hms.dto.order.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.User;
import com.furniture.hms.enums.OrderStatusEnum;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "orderCode", source = "orderCode")
    @Mapping(target = "orderStatus", source = "orderStatus")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateDate", source = "updateDate")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "totalOrder", source = "totalOrder")
    Order toOrderEntity(String createBy, Instant createDate, String orderCode, OrderStatusEnum orderStatus,
                        String updateBy, Instant updateDate, User user, BigDecimal totalOrder);

    @Mapping(target = "status" , source = "status")
    @Mapping(target = "error" , source = "error")
    @Mapping(target = "message" , source = "message")
    @Mapping(target = "orderCode" , source = "order.orderCode")
    @Mapping(target = "orderStatus" , source = "order.orderStatus")
    @Mapping(target = "totalOrder" , source = "order.totalOrder")
    @Mapping(target = "updateDate" , source = "order.updateDate")
    @Mapping(target = "userName" , source = "order.user.userName")
    OrderResponse toOrderResponse(Boolean status , String error , String message,Order order);
}
