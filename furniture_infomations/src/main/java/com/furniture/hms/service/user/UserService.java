package com.furniture.hms.service.user;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.auth.AuthenticationRequest;
import com.furniture.hms.dto.auth.AuthenticationResponse;
import com.furniture.hms.dto.user.UserRequest;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.entity.User;
import com.furniture.hms.enums.UserEnum;
import com.furniture.hms.mapper.user.UserMapper;
import com.furniture.hms.repository.user.UserRepository;
import com.furniture.hms.security.UserDetail;
import com.furniture.hms.service.jwt.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserPictureService userPictureService;

    private static final String PATH = "D:\\HomeFurniture\\frontend\\furniture_home\\src\\component\\asset\\infomation";

    public UserResponse saveEditAccount(UserRequest request) {
	UserResponse response = new UserResponse();

	User userDetail = userRepository.findUserByEmail(request.getEmail()).orElse(null);

	if (userDetail != null) {
	    try {

		if (request.getPicture().getOriginalFilename() != null || !request.getPicture().isEmpty()
			|| request.getPicture().getContentType().equals("image/jpeg")
			|| request.getPicture().getContentType().equals("image/png")) {
		    // declare file
		    String oldFileName = userDetail.getPicture();
		    String renameFile = request.getPicture().getOriginalFilename();
		    // rename to push
		    if (request.getPicture().getContentType().equals("image/jpeg")) {
			renameFile = UUID.randomUUID().toString() + ".jpg";
		    } else {
			renameFile = UUID.randomUUID().toString() + ".png";
		    }

		    // set response
		    Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(request.getBirthday());
		    BigDecimal phone = BigDecimal.valueOf(Long.parseLong(request.getPhone()));

		    userDetail.setFirstName(request.getFirstName());
		    userDetail.setLastName(request.getLastName());
		    userDetail.setUserName(request.getUserName());
		    userDetail.setAddress(request.getAddress());
		    userDetail.setBirthday(dateFormat);
		    userDetail.setNation(request.getNation());
		    userDetail.setPhone(phone.toBigInteger());
		    userDetail.setPicture(renameFile);

		    userRepository.save(userDetail);

		    // delete old image
		    UserResponse.DataUser userData = UserMapper.INSTANCE.toUserRes(userDetail);
		    UserResponse.DataUser.Orther orther = new UserResponse.DataUser.Orther();
		    if (oldFileName.equals("noImg.jpg")) {
			// save picture
			String noticeSavePicture = userPictureService.savePicture(PATH, renameFile,
				request.getPicture().getBytes());
			Map<String, Object> setOrther = new HashMap<>();
			setOrther.put("savePicture", noticeSavePicture);
			orther.setVariable(setOrther);
			userData.setOrther(orther);
		    } else {
			File tempFile = new File(PATH + "\\" + oldFileName);
			Boolean deleteCheck = tempFile.delete();
			String noticeSavePicture = userPictureService.savePicture(PATH, renameFile,
				request.getPicture().getBytes());
			Map<String, Object> setOrther = new HashMap<>();
			setOrther.put("savePicture", noticeSavePicture);
			setOrther.put("deletePicture", deleteCheck == true ? "SUCCESS" : "FAIL");
			orther.setVariable(setOrther);
			userData.setOrther(orther);
		    }

		    // set response
		    response.setStatus(true);
		    response.setError(null);
		    response.setMessage(UserMessage.SUCCESS);
		    response.setUser(userData);
		    return response;
		} else {
		    response.setStatus(false);
		    response.setError(UserMessage.FAIL);
		    response.setMessage(UserMessage.FAIL);
		    return response;
		}

	    } catch (Exception ex) {
		ex.printStackTrace();
		response.setStatus(false);
		response.setError(UserMessage.FAIL);
		response.setMessage(UserMessage.FAIL);
		return response;
	    }
	} else {
	    response.setStatus(false);
	    response.setError(UserMessage.FAIL);
	    response.setMessage(UserMessage.FAIL);
	    return response;
	}
    }

    @Transactional
    public UserResponse registerAccount(UserRequest userRequest) {
	UserResponse userResponse = new UserResponse();
	try {
	    // check mail
	    User userCheck = userRepository.findUserByEmail(userRequest.getEmail()).orElse(null);
	    if (userCheck != null) {
		userResponse.setStatus(false);
		userResponse.setError(UserMessage.FAIL);
		userResponse.setMessage(UserMessage.EMAIL_EXIST);
		return userResponse;
	    } else {
		Instant createDate = Instant.now();
		Instant updateDate = Instant.now();
		Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(userRequest.getBirthday());
		String password = bCryptPasswordEncoder.encode(userRequest.getPassword());
		BigDecimal phone = BigDecimal.valueOf(Long.parseLong(userRequest.getPhone()));
		User user = userRepository.save(UserMapper.INSTANCE.toUserEntity("noImg.jpg", phone,
			userRequest.getNation(), userRequest.getAddress(), userRequest.getFirstName(),
			userRequest.getLastName(), userRequest.getUserName(), userRequest.getEmail(), createDate,
			updateDate, dateFormat, password));
		User userDetail = userRepository.findById(user.getId()).orElse(null);
		if (userDetail != null) {
		    UserResponse.DataUser userData = UserMapper.INSTANCE.toUserRes(userDetail);
		    userResponse.setStatus(true);
		    userResponse.setError(null);
		    userResponse.setMessage(UserMessage.SUCCESS);
		    userResponse.setUser(userData);
		    return userResponse;
		} else {
		    userResponse.setStatus(true);
		    userResponse.setError(UserMessage.NOT_FOUND);
		    userResponse.setMessage(UserMessage.NOT_FOUND);
		    return userResponse;
		}
	    }
	} catch (Exception ex) {
	    ex.printStackTrace();
	    userResponse.setStatus(false);
	    userResponse.setError(UserMessage.FAIL);
	    userResponse.setMessage(UserMessage.FAIL);
	    return userResponse;
	}
    }

    public UserResponse getInfomation(String request) {
	UserResponse userResponse = new UserResponse();
	User userCheck = userRepository.findUserByEmail(request).orElse(null);
	if (userCheck != null) {
	    userResponse.setStatus(true);
	    userResponse.setError(null);
	    userResponse.setMessage(UserMessage.SUCCESS);
	    userResponse.setUser(UserMapper.INSTANCE.toUserRes(userCheck));
	    return userResponse;
	} else {
	    userResponse.setStatus(false);
	    userResponse.setError(UserMessage.NOT_FOUND);
	    userResponse.setMessage(UserMessage.NOT_FOUND);
	    return userResponse;
	}
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
	User userEntity = userRepository.findUserByEmail(request.getEmail()).orElse(null);
	if (userEntity == null) {
	    return AuthenticationResponse.builder().status(false).error("403").expired(null).message(UserMessage.FAIL)
		    .token(null).build();
	}
	if (userEntity.getStatus() == UserEnum.INVALID) {
	    return AuthenticationResponse.builder().status(false).error("401").expired(null)
		    .message(UserMessage.ACCOUNT_BLOCK).token(null).build();
	}
	try {
	    authenticationManager
		    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
	    long secondExpired = (System.currentTimeMillis() + 1000 * 60 * 24);
	    long dateExpired = new Date(secondExpired).getTime();
//            String formatExpiredToString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS").format(dateExpired);
	    UserDetail userDetail = new UserDetail(userEntity);
	    var jwtToken = jwtService.generateToken(userDetail);
	    return AuthenticationResponse.builder().status(true).error(null).expired(String.valueOf(dateExpired))
		    .message(UserMessage.SUCCESS).token(jwtToken).build();
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	    return AuthenticationResponse.builder().status(false).error("403").expired(null)
		    .message(UserMessage.BAD_CREDENTIALES).token(null).build();
	}
    }
}
