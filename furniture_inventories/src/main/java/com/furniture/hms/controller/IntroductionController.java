package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.introduction.IntroductionResponse;
import com.furniture.hms.service.introduction.IntroductionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/introduction")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class IntroductionController {

    private final IntroductionService introductionService;

    @GetMapping
    public ResponseEntity<List<IntroductionResponse>> getIntroduction() {
	List<IntroductionResponse> response = introductionService.getIntroduction();
	if (!CollectionUtils.isEmpty(response)) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
    }

}
