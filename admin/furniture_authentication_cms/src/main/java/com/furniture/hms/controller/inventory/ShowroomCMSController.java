package com.furniture.hms.controller.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.ShowroomMessage;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.showroom.ShowroomCMSRequest;
import com.furniture.hms.dto.showroom.ShowroomCMSResponse;
import com.furniture.hms.service.inventory.ShowroomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/showroom")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class ShowroomCMSController {

    private final ShowroomService showroomService;

    @GetMapping
    public ResponseEntity<ShowroomCMSResponse> getAllShowroom() {
	var response = showroomService.getShowroom();
	return new ResponseEntity<ShowroomCMSResponse>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResultData<ShowroomCMSResponse>> updateShowroom(@RequestBody ShowroomCMSRequest request) {
	var response = showroomService.updateShowroom(request);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(ShowroomMessage.SHOWROOM_SUCCESS)) {
	    return new ResponseEntity<ResultData<ShowroomCMSResponse>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<ShowroomCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
