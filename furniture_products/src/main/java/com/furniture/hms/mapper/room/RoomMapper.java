package com.furniture.hms.mapper.room;

import com.furniture.hms.dto.room.RoomResponse;
import com.furniture.hms.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    RoomResponse toRoomResponse(Room room);
}
