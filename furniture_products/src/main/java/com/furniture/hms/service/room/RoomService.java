package com.furniture.hms.service.room;

import com.furniture.hms.dto.room.RoomResponse;
import com.furniture.hms.entity.Room;
import com.furniture.hms.mapper.room.RoomMapper;
import com.furniture.hms.repository.room.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomResponse> getAllRooms() {
        List<Room> listRooms = roomRepository.findAll();

        List<RoomResponse> listRoomsResponse = new ArrayList<>();

        if(!listRooms.isEmpty()) {
            for (Room room : listRooms){
                if(room.getStatus() == 1) {
                    RoomResponse detailResponse = RoomMapper.INSTANCE.toRoomResponse(room);
                    listRoomsResponse.add(detailResponse);
                }
            }
            return listRoomsResponse;
        }else {
            return null;
        }
    }
}
