package com.furniture.hms.mapper.showroom;

import com.furniture.hms.dto.showroom.ShowroomResponse;
import com.furniture.hms.entity.Showroom;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ShowroomMapper {
    ShowroomMapper INSTANCE = Mappers.getMapper(ShowroomMapper.class);

    ShowroomResponse toShowroomRes(Showroom showroom);
}
