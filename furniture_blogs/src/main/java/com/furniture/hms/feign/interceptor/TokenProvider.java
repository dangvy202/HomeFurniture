package com.furniture.hms.feign.interceptor;

import org.springframework.stereotype.Component;

@Component
public class TokenProvider {
    private String token;

    public void setToken(String token) {
	this.token = token;
    }

    public String getToken() {
	return token;
    }
}