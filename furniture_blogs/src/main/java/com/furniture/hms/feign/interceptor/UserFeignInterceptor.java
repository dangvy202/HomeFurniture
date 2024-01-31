package com.furniture.hms.feign.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserFeignInterceptor {

    private final TokenProvider tokenProvider;

    @Bean
    public RequestInterceptor requestInterceptor() {

	return new RequestInterceptor() {
	    @Override
	    public void apply(RequestTemplate template) {
		template.header("Authorization", "Bearer " + tokenProvider.getToken());
	    }
	};
    }
}