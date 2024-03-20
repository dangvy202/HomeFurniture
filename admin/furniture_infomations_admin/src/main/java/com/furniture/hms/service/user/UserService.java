package com.furniture.hms.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.entity.User;
import com.furniture.hms.mapper.user.UserMapper;
import com.furniture.hms.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResultData<List<UserResponse>> getAllUser() {
	List<UserResponse> response = new ArrayList<>();

	List<User> userList = userRepository.findAll();

	if (!CollectionUtils.isEmpty(userList)) {
	    userList.forEach(user -> {
		UserResponse userResponse = new UserResponse();

		userResponse = UserMapper.INSTANCE.toUserRes(user);
		response.add(userResponse);
	    });
	    return new ResultData<List<UserResponse>>(Boolean.TRUE, null, UserMessage.SUCCESS, response);
	}
	return new ResultData<List<UserResponse>>(Boolean.FALSE, UserMessage.FAIL, UserMessage.FAIL, response);
    }

    public ResultData<UserResponse> getDetailUserByEmail(String email) {
	UserResponse response = new UserResponse();

	User user = userRepository.findUserByEmail(email).orElse(null);

	if (user != null) {
	    response = UserMapper.INSTANCE.toUserRes(user);

	    return new ResultData<UserResponse>(Boolean.TRUE, null, UserMessage.SUCCESS, response);
	}

	return new ResultData<UserResponse>(Boolean.FALSE, UserMessage.NOT_FOUND, UserMessage.NOT_FOUND, response);
    }
}
