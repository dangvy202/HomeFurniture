package com.furniture.hms.controller;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.auth.AuthenticationRequest;
import com.furniture.hms.dto.auth.AuthenticationResponse;
import com.furniture.hms.dto.user.UserRequest;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UsersController {

    private final UserService userService;

//    @PostMapping("/check")
//    public ResponseEntity<UserResponse> saveInfomatioasdadn(@RequestParam(UserRequest) String request){
////        UserResponse response = userService.saveEditAccount(request);
////        if(response == null) {
////            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
////        } else {
////            return new ResponseEntity<>(response,HttpStatus.CREATED);
////        }
//        return null;
//    }

    @PostMapping("/img/save")
    public ResponseEntity<String> saveImageInfomation(@RequestBody MultipartFile picture) throws Exception {
        String response = userService.saveImageInfomation(picture);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> saveInfomation(@ModelAttribute @Validated UserRequest request){
        UserResponse response = userService.saveEditAccount(request);
        if(response == null) {
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerAccount(@Validated @RequestBody UserRequest userRequest) {
        UserResponse response = userService.registerAccount(userRequest);
        if(response == null){
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/infomation/{email}")
    public ResponseEntity<UserResponse> infomationAccount(@PathVariable("email") String email) {
        UserResponse response = userService.getInfomation(email);
        if(response == null){
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        var response = userService.login(request);
        if(response.getMessage() == UserMessage.FAIL){
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }else if(response.getMessage() == UserMessage.BAD_CREDENTIALES) {
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
