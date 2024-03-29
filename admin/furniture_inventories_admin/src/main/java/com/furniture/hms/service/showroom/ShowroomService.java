package com.furniture.hms.service.showroom;

import com.furniture.hms.dto.showroom.ShowroomResponse;
import com.furniture.hms.entity.Showroom;
import com.furniture.hms.mapper.showroom.ShowroomMapper;
import com.furniture.hms.repository.showroom.ShowroomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShowroomService {

    private final ShowroomRepository repository;

    public ShowroomResponse getShowroom() {
        ShowroomResponse response = new ShowroomResponse();
        Showroom showroom = repository.findAll().stream().findFirst().orElse(null);
        if(showroom != null) {
            response = ShowroomMapper.INSTANCE.toShowroomRes(showroom);
            return response;
        }
        return  response;
    }
}
