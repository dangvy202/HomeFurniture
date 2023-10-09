package com.furniture.hms.mapper.user;

import com.furniture.hms.dto.user.UserRequest;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse.DataUser toUserRes(User user);

    @Mapping(target = "password" , source = "password")
    @Mapping(target = "role" , constant = "USER")
    @Mapping(target = "birthday" , source = "birthday")
    @Mapping(target = "createBy" , constant = "Vy")
    @Mapping(target = "createDate" , source = "createDate")
    @Mapping(target = "updateBy" , constant = "Vy")
    @Mapping(target = "updateDate" , source = "updateDate")
    User toUserEntity(UserRequest request, Instant createDate, Instant updateDate, Date birthday,String password);
}
