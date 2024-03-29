package com.furniture.hms.mapper.social;


import com.furniture.hms.dto.social.SocialResponse;
import com.furniture.hms.entity.Social;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SocialMapper {

    SocialMapper INSTANCE = Mappers.getMapper(SocialMapper.class);

    SocialResponse toSocialRes(Social social);
}
