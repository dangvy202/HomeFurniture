package com.furniture.hms.service.social;

import com.furniture.hms.dto.social.SocialResponse;
import com.furniture.hms.entity.Social;
import com.furniture.hms.mapper.social.SocialMapper;
import com.furniture.hms.repository.social.SocialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocialService {

    private final SocialRepository repository;

    public SocialResponse getSocialUrl() {
        SocialResponse response = new SocialResponse();
        Social social = repository.findAll().stream().findFirst().orElse(null);
        if(social != null) {
            response = SocialMapper.INSTANCE.toSocialRes(social);
            return response;
        }
        return  response;
    }
}
