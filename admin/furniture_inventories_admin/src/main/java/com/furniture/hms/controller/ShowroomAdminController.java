package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.showroom.ShowroomRequest;
import com.furniture.hms.dto.showroom.ShowroomResponse;
import com.furniture.hms.service.showroom.ShowroomService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/showroom")
@RequiredArgsConstructor
public class ShowroomAdminController {

    private final ShowroomService showroomService;

    @GetMapping
    public ResponseEntity<ShowroomResponse> getShowroom() {
	var response = showroomService.getShowroom();
	return new ResponseEntity<ShowroomResponse>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResultData<ShowroomResponse>> updateShowroom(@RequestBody ShowroomRequest request) {
	var response = showroomService.updateShowroom(request);
	return new ResponseEntity<ResultData<ShowroomResponse>>(response, HttpStatus.OK);
    }

}
