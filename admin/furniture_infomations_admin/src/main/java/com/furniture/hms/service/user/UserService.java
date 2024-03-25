package com.furniture.hms.service.user;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.user.UserRequest;
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

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResultData<UserResponse> registerNewUser(UserRequest request) {
	UserResponse response = new UserResponse();

	User user = userRepository.findUserByEmail(request.getEmail()).orElse(null);

	if (user == null) {
	    try {
		Date birthDayFormat = new SimpleDateFormat("yyyy-MM-dd").parse(request.getBirthday());
		User userRegister = UserMapper.INSTANCE.toUserEntity("noImg.jpg", request.getPhone(),
			request.getNation(), request.getAddress(), request.getFirstName(), request.getLastName(),
			request.getUserName(), request.getEmail(), Instant.now(), Instant.now(), birthDayFormat,
			bCryptPasswordEncoder.encode(request.getPassword()), "VY", request.getRole());
		response = UserMapper.INSTANCE.toUserRes(userRegister);

		userRepository.save(userRegister);
		return new ResultData<UserResponse>(Boolean.TRUE, null, UserMessage.SUCCESS, response);
	    } catch (Exception e) {
		log.error(e.getMessage());
		return new ResultData<UserResponse>(Boolean.FALSE, UserMessage.EXCEPTION, e.getMessage(), response);
	    }
	}

	return new ResultData<UserResponse>(Boolean.FALSE, UserMessage.EMAIL_EXIST, UserMessage.EMAIL_EXIST, response);

    }

    public ResultData<UserResponse> saveEditUserByEmail(UserRequest request) {
	User user = userRepository.findUserByEmail(request.getEmail()).orElse(null);

	if (user != null) {
	    try {
		Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getBirthday());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		user.setAddress(request.getAddress());
		user.setBirthday(birthday);
		user.setRole(request.getRole());
		user.setNation(request.getNation());
		user.setPhone(request.getPhone());
		user.setUpdateBy("VY");
		user.setUpdateDate(Instant.now());

		userRepository.save(user);

		return new ResultData<UserResponse>(Boolean.TRUE, null, UserMessage.SUCCESS, null);
	    } catch (Exception e) {

		log.error(e.getMessage());

		return new ResultData<UserResponse>(Boolean.FALSE, UserMessage.EXCEPTION, e.getMessage(), null);
	    }
	}

	return new ResultData<UserResponse>(Boolean.FALSE, UserMessage.NOT_FOUND, UserMessage.NOT_FOUND, null);
    }

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
