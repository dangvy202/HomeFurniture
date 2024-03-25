package com.furniture.hms.mapper.informationOrder;

import java.math.BigDecimal;
import java.time.Instant;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.information_order.InformationOrderResponse;
import com.furniture.hms.entity.InformationOrder;
import com.furniture.hms.entity.Order;

@Mapper(componentModel = "spring")
public interface InformationOrderMapper {
    InformationOrderMapper INSTANCE = Mappers.getMapper(InformationOrderMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userName", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "order", source = "order")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateDate", source = "updateDate")
    InformationOrder toInformationOrderEntity(String username, String email, String address, BigDecimal phone,
	    Order order, String createBy, Instant createDate, String updateBy, Instant updateDate);

    InformationOrderResponse.InformationOrderDetail toInformationOrderDetail(String address, String email, String phone,
	    String userName);
}
