package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.auth.AuthenticationRequest;
import com.furniture.hms.dto.auth.AuthenticationResponse;
import com.furniture.hms.service.login.LoginService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class LoginCMSController {

    private final LoginService userService;

    @PostMapping("/authentication/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
	var response = userService.login(request);
	if (response.getMessage() == UserMessage.FAIL) {
	    return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	} else if (response.getMessage() == UserMessage.BAD_CREDENTIALES) {
	    return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	}
	return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
