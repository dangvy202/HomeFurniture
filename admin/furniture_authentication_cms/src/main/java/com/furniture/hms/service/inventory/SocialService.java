package com.furniture.hms.service.inventory;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.social.SocialCMSRequest;
import com.furniture.hms.dto.social.SocialCMSResponse;
import com.furniture.hms.feign.inventory.SocialCMSFeign;
import com.furniture.hms.service.spi.inventory.SocialServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocialService implements SocialServiceSpi {

    private final SocialCMSFeign socialCMSFeign;

    @Override
    public SocialCMSResponse getSocial() {
	SocialCMSResponse response = socialCMSFeign.getSocial();
	return response;
    }

    @Override
    public ResultData<SocialCMSResponse> updateSocial(SocialCMSRequest request) {
	ResultData<SocialCMSResponse> response = socialCMSFeign.updateSocial(request);
	return response;
    }

}
