package com.furniture.hms.feign.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configuration
public class UserFeignInterceptor {

    @Autowired
    private TokenProvider tokenProvider;

    @Bean
    public RequestInterceptor requestInterceptor() {
	return new RequestInterceptor() {
	    @Override
	    public void apply(RequestTemplate template) {
		String token = tokenProvider.getToken();
		template.header("Authorization", "Bearer " + token);
	    }
	};
    }
}