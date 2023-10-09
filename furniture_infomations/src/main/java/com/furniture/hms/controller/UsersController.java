package com.furniture.hms.controller;

import com.furniture.hms.dto.user.UserRequest;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerAccount(@Validated @RequestBody UserRequest userRequest) {
        UserResponse response = userService.registerAccount(userRequest);
        if(response == null){
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/infomation")
    public ResponseEntity<UserResponse> infomationAccount(@RequestHeader("email") String email) {
        UserResponse response = userService.getInfomation(email);
        if(response == null){
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
