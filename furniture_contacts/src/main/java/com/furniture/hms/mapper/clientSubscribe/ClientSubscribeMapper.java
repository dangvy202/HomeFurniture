package com.furniture.hms.mapper.clientSubscribe;

import com.furniture.hms.dto.clientSubscribe.ClientSubscribeResponse;
import com.furniture.hms.entity.ClientSubscribe;
import com.furniture.hms.enums.CheckMailEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ClientSubscribeMapper {

    ClientSubscribeMapper INSTANCE = Mappers.getMapper(ClientSubscribeMapper.class);

    ClientSubscribeResponse toClientSubscribeResponse(ClientSubscribe clientSubscribe);

    @Mapping(target = "email" , source = "email")
    @Mapping(target = "checkMail" , source = "checkMailEnum")
    @Mapping(target = "createDate" , source = "date")
    ClientSubscribe toClientEntity(String email, CheckMailEnum checkMailEnum , Instant date);
}
