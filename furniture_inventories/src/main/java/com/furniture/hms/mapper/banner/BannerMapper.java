package com.furniture.hms.mapper.banner;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.entity.Banner;

@Mapper(componentModel = "spring")
public interface BannerMapper {
    BannerMapper INSTANCE = Mappers.getMapper(BannerMapper.class);

    BannerResponse toBannerRes(Banner banner);
}
