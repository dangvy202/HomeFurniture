package com.furniture.hms.mapper.wishlist;

import java.math.BigDecimal;
import java.time.Instant;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.wishlist.WishlistOrderResponse;
import com.furniture.hms.entity.User;
import com.furniture.hms.entity.WishlistOrder;

@Mapper(componentModel = "spring")
public interface WishlistOrderMapper {

    WishlistOrderMapper INSTANCE = Mappers.getMapper(WishlistOrderMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idProduct", source = "idProduct")
    @Mapping(target = "wishlistQuantity", source = "wishlistQuantity")
    @Mapping(target = "totalPrice", source = "totalPrice")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateDate", source = "updateDate")
    WishlistOrder toWishlistOrderEntity(BigDecimal totalPrice, int idProduct, int wishlistQuantity, User user,
	    String createBy, Instant createDate, String updateBy, Instant updateDate);

    @Mapping(target = "id", source = "idProduct")
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "productPrice", source = "productPrice")
    @Mapping(target = "productSaleoff", source = "productSaleoff")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "totalPrice", source = "totalPrice")
    WishlistOrderResponse.Product toWishlistProductOrderResponse(BigDecimal totalPrice, int idProduct,
	    String productName, BigDecimal productPrice, BigDecimal productSaleoff, int quantity);

    @Mapping(target = "picture", source = "picture")
    WishlistOrderResponse.Product.Picture toWishlistPictureOrderResponse(String picture);
}
