package com.furniture.hms.mapper.rating;

import com.furniture.hms.dto.rating.RatingResponse;
import com.furniture.hms.entity.Rating;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RatingMapper {

    RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);

    RatingResponse toRatingResponse(Rating rating);
}
