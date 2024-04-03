package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.banner.BannerRequest;
import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.banner.BannerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/banner")
@RequiredArgsConstructor
public class BannerAdminController {

    private final BannerService bannerService;

    @PostMapping("/update")
    public ResponseEntity<ResultData<BannerResponse>> updateBanner(@ModelAttribute @Validated BannerRequest request) {
	var response = bannerService.updateBanner(request);
	return new ResponseEntity<ResultData<BannerResponse>>(response, HttpStatus.OK);
    }

}
