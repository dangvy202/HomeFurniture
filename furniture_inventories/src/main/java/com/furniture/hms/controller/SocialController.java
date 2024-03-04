package com.furniture.hms.controller;

import com.furniture.hms.dto.showroom.ShowroomResponse;
import com.furniture.hms.dto.social.SocialResponse;
import com.furniture.hms.service.social.SocialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class SocialController {

    private final SocialService service;

    @GetMapping
    public ResponseEntity<SocialResponse> getSocialUrl() {
        SocialResponse response = service.getSocialUrl();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
