package com.furniture.hms.mapper.introduction;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.introduction.IntroductionResponse;
import com.furniture.hms.entity.Introduction;

@Mapper(componentModel = "spring")
public interface IntroductionMapper {
    IntroductionMapper INSTANCE = Mappers.getMapper(IntroductionMapper.class);

    IntroductionResponse toIntroductionRes(Introduction introduction);
}
