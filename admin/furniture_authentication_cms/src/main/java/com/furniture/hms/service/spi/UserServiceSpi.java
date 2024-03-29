package com.furniture.hms.service.spi;

import java.util.List;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.user.UserCMSRequest;
import com.furniture.hms.dto.user.UserCMSResponse;

@Component
public interface UserServiceSpi {
    ResultData<UserCMSResponse> blockAccount(UserCMSRequest request);

    ResultData<UserCMSResponse> registerNewUser(UserCMSRequest request);

    ResultData<UserCMSResponse> saveEditUserByEmail(UserCMSRequest request);

    ResultData<List<UserCMSResponse>> getAllUser();

    ResultData<UserCMSResponse> getDetailUserByEmail(String email);
}
