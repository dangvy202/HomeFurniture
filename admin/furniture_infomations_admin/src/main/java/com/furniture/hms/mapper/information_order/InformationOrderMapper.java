package com.furniture.hms.mapper.information_order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.information_order.InformationOrderResponse;
import com.furniture.hms.entity.InformationOrder;

@Mapper(componentModel = "spring")
public interface InformationOrderMapper {
    InformationOrderMapper INSTANCE = Mappers.getMapper(InformationOrderMapper.class);

    @Mapping(target = "address", source = "informationOrder.address")
    @Mapping(target = "email", source = "informationOrder.email")
    @Mapping(target = "phone", source = "informationOrder.phone")
    @Mapping(target = "userName", source = "informationOrder.userName")
    InformationOrderResponse toInformationOrderRes(InformationOrder informationOrder);

    @Mapping(target = "orderCode", source = "informationOrder.order.orderCode")
    @Mapping(target = "orderStatus", source = "informationOrder.order.orderStatus")
    @Mapping(target = "totalOrder", source = "informationOrder.order.totalOrder")
    @Mapping(target = "updateDate", source = "informationOrder.order.updateDate")
    @Mapping(target = "userName", source = "informationOrder.order.user.userName")
    @Mapping(target = "phone", source = "informationOrder.order.user.phone")
    @Mapping(target = "email", source = "informationOrder.order.user.email")
    InformationOrderResponse.Order toOrderResponse(InformationOrder informationOrder);
}
