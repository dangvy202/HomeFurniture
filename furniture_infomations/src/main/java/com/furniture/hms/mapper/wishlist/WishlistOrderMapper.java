package com.furniture.hms.mapper.wishlist;

import java.time.Instant;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.entity.User;
import com.furniture.hms.entity.WishlistOrder;

@Mapper(componentModel = "spring")
public interface WishlistOrderMapper {

    WishlistOrderMapper INSTANCE = Mappers.getMapper(WishlistOrderMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idProduct", source = "idProduct")
    @Mapping(target = "wishlistQuantity", source = "wishlistQuantity")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateDate", source = "updateDate")
    WishlistOrder toWishlistOrderEntity(int idProduct, int wishlistQuantity, User user, String createBy,
	    Instant createDate, String updateBy, Instant updateDate);
}
