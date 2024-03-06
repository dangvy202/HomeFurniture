package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.service.banner.BannerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/banner")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class BannerController {

    private final BannerService service;

    @GetMapping
    public ResponseEntity<List<BannerResponse>> getAllBannerAndSpecialProduct() {
	List<BannerResponse> response = service.getAllBanner();
	if (!CollectionUtils.isEmpty(response)) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
    }

}
