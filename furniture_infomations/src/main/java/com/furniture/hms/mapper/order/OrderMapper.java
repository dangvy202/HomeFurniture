package com.furniture.hms.mapper.order;

import com.furniture.hms.dto.order.OrderResponse;
import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "orderId" , source = "orderId")
    @Mapping(target = "orderStatus" , constant = "PAID")
    @Mapping(target = "orderQuantity" , source = "quantity")
    @Mapping(target = "user" , source = "user")
    @Mapping(target = "idProduct" , source = "idProduct")
    @Mapping(target = "createBy" , source = "user.lastName")
    @Mapping(target = "createDate" , source = "createDate")
    @Mapping(target = "updateBy" , constant = "user.lastName")
    @Mapping(target = "updateDate" , source = "updateDate")
    Order toOrder(String orderId, int quantity, User user, int idProduct, Instant createDate,Instant updateDate);


}
