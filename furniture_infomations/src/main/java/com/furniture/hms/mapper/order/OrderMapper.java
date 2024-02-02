package com.furniture.hms.mapper.order;


import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.User;
import com.furniture.hms.enums.OrderStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "createBy" , source = "createBy")
    @Mapping(target = "createDate" , source = "createDate")
    @Mapping(target = "orderCode" , source = "orderCode")
    @Mapping(target = "orderStatus" , source = "orderStatus")
    @Mapping(target = "updateBy" , source = "updateBy")
    @Mapping(target = "updateDate" , source = "updateDate")
    @Mapping(target = "user" , source = "user")
    Order toOrderEntity(String createBy, Instant createDate, String orderCode, OrderStatusEnum orderStatus, String updateBy, Instant updateDate, User user);
}
