package com.furniture.hms.controller.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.SocialMessage;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.social.SocialCMSRequest;
import com.furniture.hms.dto.social.SocialCMSResponse;
import com.furniture.hms.service.inventory.SocialService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/social")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class SocialCMSController {

    private final SocialService socialService;

    @GetMapping
    public ResponseEntity<SocialCMSResponse> getSocial() {
	var response = socialService.getSocial();
	return new ResponseEntity<SocialCMSResponse>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResultData<SocialCMSResponse>> updateSocial(@RequestBody SocialCMSRequest request) {
	var response = socialService.updateSocial(request);

	if (response.getStatus() == Boolean.TRUE && response.getMessage().equals(SocialMessage.SOCIAL_SUCCESS)) {
	    return new ResponseEntity<ResultData<SocialCMSResponse>>(response, HttpStatus.OK);
	}

	return new ResponseEntity<ResultData<SocialCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
