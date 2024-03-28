package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.user.UserCMSRequest;
import com.furniture.hms.dto.user.UserCMSResponse;
import com.furniture.hms.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class UserCMSController {

    private final UserService userService;

    @PostMapping("/block")
    public ResponseEntity<ResultData<UserCMSResponse>> blockAccount(@RequestBody UserCMSRequest request) {
	var response = userService.blockAccount(request);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(UserMessage.SUCCESS)) {
	    return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/save")
    public ResponseEntity<ResultData<UserCMSResponse>> registerUser(@RequestBody UserCMSRequest request) {
	var response = userService.registerNewUser(request);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(UserMessage.SUCCESS)) {
	    return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.CREATED);
	}

	return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/edit/save")
    public ResponseEntity<ResultData<UserCMSResponse>> saveEditUser(@RequestBody UserCMSRequest request) {
	var response = userService.saveEditUserByEmail(request);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(UserMessage.SUCCESS)) {
	    return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.OK);
	}
	return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<ResultData<List<UserCMSResponse>>> getAllUser() {
	var response = userService.getAllUser();

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(UserMessage.SUCCESS)) {
	    return new ResponseEntity<ResultData<List<UserCMSResponse>>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<List<UserCMSResponse>>>(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResultData<UserCMSResponse>> getUserDetail(@PathVariable("email") String email) {
	var response = userService.getDetailUserByEmail(email);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(UserMessage.SUCCESS)) {
	    return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.OK);
	}
	return new ResponseEntity<ResultData<UserCMSResponse>>(response, HttpStatus.NOT_FOUND);
    }
}
