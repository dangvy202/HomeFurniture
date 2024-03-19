package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class UserAdminController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ResultData<List<UserResponse>>> getAllUser() {
	var response = userService.getAllUser();

	if (response.getStatus() == Boolean.TRUE && response.getMessage() == UserMessage.SUCCESS) {
	    return new ResponseEntity<ResultData<List<UserResponse>>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<List<UserResponse>>>(response, HttpStatus.NOT_FOUND);
    }

}
