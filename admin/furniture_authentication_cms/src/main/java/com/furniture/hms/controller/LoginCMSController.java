package com.furniture.hms.controller;

import jakarta.annotation.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/authentication/cache/login")
	public ResponseEntity<Object> getTokenWhenLoginSuccess(@RequestHeader("key-cache") @Nullable String keyRedis) {
		var response = userService.getTokenInRedis(keyRedis);

		if(response.equals(UserMessage.FAIL) || response.getMessage().equals(UserMessage.EXPIRED_USER) || keyRedis.isEmpty()) {
			return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

    @PostMapping("/authentication/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
		var response = userService.login(request);

		if (response.getMessage().equals(UserMessage.FAIL)) {
			return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
		} else if (response.getMessage().equals(UserMessage.BAD_CREDENTIALES)) {
			return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
		}
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
