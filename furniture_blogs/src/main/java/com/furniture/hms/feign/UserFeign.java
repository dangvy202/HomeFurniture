package com.furniture.hms.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.furniture.hms.feign.interceptor.UserFeignInterceptor;
import com.furniture.hms.feign.response.UserResponse.UserResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInfomations", configuration = UserFeignInterceptor.class, fallbackFactory = UserFeign.UserFeignFallBack.class)
public interface UserFeign {

    @GetMapping("/user/infomation/{email}")
    UserResponse infomationAccount(@PathVariable("email") String email);

    @Component
    @Slf4j
    class UserFeignFallBack implements FallbackFactory<UserFeign> {

	@Override
	public UserFeign create(Throwable throwable) {
	    return new UserFeign() {
		@Override
		public UserResponse infomationAccount(String email) {
		    log.error("User error by user id: " + throwable.getMessage());
		    return null;
		}
	    };
	}
    }
}
