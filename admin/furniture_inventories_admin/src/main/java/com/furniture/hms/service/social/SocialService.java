package com.furniture.hms.service.social;

import org.springframework.stereotype.Service;

import com.furniture.hms.constant.ShowroomMessage;
import com.furniture.hms.constant.SocialMessage;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.social.SocialRequest;
import com.furniture.hms.dto.social.SocialResponse;
import com.furniture.hms.entity.Social;
import com.furniture.hms.mapper.social.SocialMapper;
import com.furniture.hms.repository.social.SocialRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocialService {

    private final SocialRepository repository;

    public SocialResponse getSocialUrl() {
	SocialResponse response = new SocialResponse();
	Social social = repository.findAll().stream().findFirst().orElse(null);
	if (social != null) {
	    response = SocialMapper.INSTANCE.toSocialRes(social);
	    return response;
	}
	return response;
    }

    public ResultData<SocialResponse> updateSocial(SocialRequest request) {
	SocialResponse response = new SocialResponse();
	Social social = repository.findAll().stream().findFirst().orElse(null);

	if (social != null) {
	    social.setFacebook(request.getFacebook());
	    social.setInstagram(request.getInstagram());
	    social.setTiktok(request.getTiktok());
	    social.setTwiter(request.getTwiter());

	    response = SocialMapper.INSTANCE.toSocialRes(social);
	    repository.save(social);
	    return new ResultData<SocialResponse>(Boolean.TRUE, null, SocialMessage.SOCIAL_SUCCESS, response);
	}
	return new ResultData<SocialResponse>(Boolean.FALSE, SocialMessage.SOCIAL_FAIL, ShowroomMessage.SHOWROOM_FAIL,
		response);
    }
}
