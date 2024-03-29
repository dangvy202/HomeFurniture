package com.furniture.hms.service.showroom;

import org.springframework.stereotype.Service;

import com.furniture.hms.constant.ShowroomMessage;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.showroom.ShowroomRequest;
import com.furniture.hms.dto.showroom.ShowroomResponse;
import com.furniture.hms.entity.Showroom;
import com.furniture.hms.mapper.showroom.ShowroomMapper;
import com.furniture.hms.repository.showroom.ShowroomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShowroomService {

    private final ShowroomRepository repository;

    public ShowroomResponse getShowroom() {
	ShowroomResponse response = new ShowroomResponse();
	Showroom showroom = repository.findAll().stream().findFirst().orElse(null);
	if (showroom != null) {
	    response = ShowroomMapper.INSTANCE.toShowroomRes(showroom);
	    return response;
	}
	return response;
    }

    public ResultData<ShowroomResponse> updateShowroom(ShowroomRequest request) {
	ShowroomResponse response = new ShowroomResponse();
	Showroom showroom = repository.findAll().stream().findFirst().orElse(null);

	if (showroom != null) {
	    showroom.setAddress(request.getAddress());
	    showroom.setDayOpen(request.getDayOpen());
	    showroom.setTimeOpen(request.getTimeOpen());
	    showroom.setMail(request.getMail());
	    showroom.setPhone(request.getPhone());
	    response = ShowroomMapper.INSTANCE.toShowroomRes(showroom);
	    repository.save(showroom);
	    return new ResultData<ShowroomResponse>(Boolean.TRUE, null, ShowroomMessage.SHOWROOM_SUCCESS, response);
	}
	return new ResultData<ShowroomResponse>(Boolean.FALSE, ShowroomMessage.SHOWROOM_FAIL,
		ShowroomMessage.SHOWROOM_FAIL, response);
    }
}
