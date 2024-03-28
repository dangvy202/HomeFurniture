package com.furniture.hms.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.user.UserCMSRequest;
import com.furniture.hms.dto.user.UserCMSResponse;
import com.furniture.hms.feign.UserCMSFeign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserCMSFeign userCMSFeign;

    public ResultData<UserCMSResponse> blockAccount(UserCMSRequest request) {
	ResultData<UserCMSResponse> response = userCMSFeign.blockAccount(request);
	return response;
    }

    public ResultData<UserCMSResponse> registerNewUser(UserCMSRequest request) {
	ResultData<UserCMSResponse> response = userCMSFeign.registerUser(request);
	return response;

    }

    public ResultData<UserCMSResponse> saveEditUserByEmail(UserCMSRequest request) {
	ResultData<UserCMSResponse> response = userCMSFeign.saveEditUser(request);
	return response;
    }

    public ResultData<List<UserCMSResponse>> getAllUser() {
	ResultData<List<UserCMSResponse>> response = userCMSFeign.getAllUser();
	return response;
    }

    public ResultData<UserCMSResponse> getDetailUserByEmail(String email) {
	ResultData<UserCMSResponse> response = userCMSFeign.getUserDetail(email);
	return response;
    }
}
