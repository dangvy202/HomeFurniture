package com.furniture.hms.controller.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.BannerMessage;
import com.furniture.hms.dto.banner.BannerCMSRequest;
import com.furniture.hms.dto.banner.BannerCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.service.inventory.BannerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/banner")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class BannerCMSController {

    private final BannerService bannerService;

    @PostMapping("/update")
    public ResponseEntity<ResultData<BannerCMSResponse>> updateBanner(
	    @ModelAttribute @Validated BannerCMSRequest request) {
	var response = bannerService.updateBanner(request);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(BannerMessage.BANNER_SUCCESS)) {
	    return new ResponseEntity<ResultData<BannerCMSResponse>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<BannerCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
