package com.furniture.hms.mapper.productSpecial;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.feign.response.ProductResponse.ProductFeignResponse;

@Mapper(componentModel = "spring")
public interface ProductSpecialMapper {
    ProductSpecialMapper INSTANCE = Mappers.getMapper(ProductSpecialMapper.class);

    BannerResponse.ProductResponse toProductBannerRes(ProductFeignResponse productFeignResponse);
}
