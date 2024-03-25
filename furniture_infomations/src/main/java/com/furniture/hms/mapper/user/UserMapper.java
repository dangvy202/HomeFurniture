package com.furniture.hms.mapper.user;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponse.DataUser toUserRes(User user);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "userName", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "nation", source = "nation")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "picture", source = "picture")
    @Mapping(target = "role", constant = "USER")
    @Mapping(target = "birthday", source = "birthday")
    @Mapping(target = "createBy", constant = "Vy")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "updateBy", constant = "Vy")
    @Mapping(target = "updateDate", source = "updateDate")
    @Mapping(target = "status", constant = "VALID")
    User toUserEntity(String picture, BigDecimal phone, String nation, String address, String firstName,
	    String lastName, String username, String email, Instant createDate, Instant updateDate, Date birthday,
	    String password);
}
