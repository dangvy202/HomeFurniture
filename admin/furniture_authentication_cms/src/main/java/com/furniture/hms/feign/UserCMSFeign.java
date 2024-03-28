package com.furniture.hms.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.user.UserCMSRequest;
import com.furniture.hms.dto.user.UserCMSResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInfomationsAdmin", contextId = "UserCMSFeign", fallbackFactory = UserCMSFeign.UserCMSFeignFallBack.class)
public interface UserCMSFeign {

    @PostMapping("/user/block")
    ResultData<UserCMSResponse> blockAccount(@RequestBody UserCMSRequest request);

    @PostMapping("/user/save")
    ResultData<UserCMSResponse> registerUser(@RequestBody UserCMSRequest request);

    @PutMapping("/user/edit/save")
    ResultData<UserCMSResponse> saveEditUser(@RequestBody UserCMSRequest request);

    @GetMapping("/user")
    ResultData<List<UserCMSResponse>> getAllUser();

    @GetMapping("/user/{email}")
    ResultData<UserCMSResponse> getUserDetail(@PathVariable("email") String email);

    @Component
    @Slf4j
    class UserCMSFeignFallBack implements FallbackFactory<UserCMSFeign> {

	@Override
	public UserCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
