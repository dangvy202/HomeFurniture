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

import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.user.UserRequest;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.service.user.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class UserAdminController {

    private final UserService userService;

    @PostMapping("/block")
    public ResponseEntity<ResultData<UserResponse>> blockAccount(@RequestBody UserRequest request) {
	var response = userService.blockAccount(request);
	return new ResponseEntity<ResultData<UserResponse>>(response, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ResultData<UserResponse>> registerUser(@RequestBody UserRequest request) {
	var response = userService.registerNewUser(request);
	return new ResponseEntity<ResultData<UserResponse>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/edit/save")
    public ResponseEntity<ResultData<UserResponse>> saveEditUser(@RequestBody UserRequest request) {
	var response = userService.saveEditUserByEmail(request);
	return new ResponseEntity<ResultData<UserResponse>>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResultData<List<UserResponse>>> getAllUser() {
	var response = userService.getAllUser();
	return new ResponseEntity<ResultData<List<UserResponse>>>(response, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResultData<UserResponse>> getUserDetail(@PathVariable("email") String email) {
	var response = userService.getDetailUserByEmail(email);
	return new ResponseEntity<ResultData<UserResponse>>(response, HttpStatus.OK);
    }
}
