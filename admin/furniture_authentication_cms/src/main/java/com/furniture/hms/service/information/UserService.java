package com.furniture.hms.service.information;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.user.UserCMSRequest;
import com.furniture.hms.dto.user.UserCMSResponse;
import com.furniture.hms.feign.information.UserCMSFeign;
import com.furniture.hms.service.spi.information.UserServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserServiceSpi {

    private final UserCMSFeign userCMSFeign;

    @Override
    public ResultData<UserCMSResponse> blockAccount(UserCMSRequest request) {
	ResultData<UserCMSResponse> response = userCMSFeign.blockAccount(request);
	return response;
    }

    @Override
    public ResultData<UserCMSResponse> registerNewUser(UserCMSRequest request) {
	ResultData<UserCMSResponse> response = userCMSFeign.registerUser(request);
	return response;

    }

    @Override
    public ResultData<UserCMSResponse> saveEditUserByEmail(UserCMSRequest request) {
	ResultData<UserCMSResponse> response = userCMSFeign.saveEditUser(request);
	return response;
    }

    @Override
    public ResultData<List<UserCMSResponse>> getAllUser() {
	ResultData<List<UserCMSResponse>> response = userCMSFeign.getAllUser();
	return response;
    }

    @Override
    public ResultData<UserCMSResponse> getDetailUserByEmail(String email) {
	ResultData<UserCMSResponse> response = userCMSFeign.getUserDetail(email);
	return response;
    }
}
