package com.furniture.hms.mapper.cooperate;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.cooperate.CooperateResponse;
import com.furniture.hms.entity.Blog;

@Mapper(componentModel = "spring")
public interface CooperateMapper {
    CooperateMapper INSTANCE = Mappers.getMapper(CooperateMapper.class);

    CooperateResponse.BlogDetail toCooperateResponse(Blog blog);

}
