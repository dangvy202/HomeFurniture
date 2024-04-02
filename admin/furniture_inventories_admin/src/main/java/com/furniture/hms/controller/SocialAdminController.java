package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.social.SocialRequest;
import com.furniture.hms.dto.social.SocialResponse;
import com.furniture.hms.service.social.SocialService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/social")
@RequiredArgsConstructor
public class SocialAdminController {

    private final SocialService socialService;

    @GetMapping
    public ResponseEntity<SocialResponse> getSocial() {
	var response = socialService.getSocialUrl();
	return new ResponseEntity<SocialResponse>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResultData<SocialResponse>> updateSocial(@RequestBody SocialRequest request) {
	var response = socialService.updateSocial(request);
	return new ResponseEntity<ResultData<SocialResponse>>(response, HttpStatus.OK);
    }

}
