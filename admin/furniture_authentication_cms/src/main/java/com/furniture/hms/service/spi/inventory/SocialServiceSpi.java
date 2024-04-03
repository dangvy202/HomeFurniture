package com.furniture.hms.service.spi.inventory;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.social.SocialCMSRequest;
import com.furniture.hms.dto.social.SocialCMSResponse;

@Component
public interface SocialServiceSpi {

    SocialCMSResponse getSocial();

    ResultData<SocialCMSResponse> updateSocial(SocialCMSRequest request);
}
