package com.furniture.hms.service.login;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.auth.AuthenticationRequest;
import com.furniture.hms.dto.auth.AuthenticationResponse;
import com.furniture.hms.entity.User;
import com.furniture.hms.enums.UserEnum;
import com.furniture.hms.repository.user.UserRepository;
import com.furniture.hms.security.UserDetail;
import com.furniture.hms.service.jwt.JwtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public AuthenticationResponse login(AuthenticationRequest request) {
	User userEntity = userRepository.findUserByEmail(request.getEmail()).orElse(null);
	if (userEntity == null) {
	    return AuthenticationResponse.builder().status(false).error("403").expired(null).message(UserMessage.FAIL)
		    .token(null).build();
	}
	if (userEntity.getStatus() != UserEnum.VALID) {
	    return AuthenticationResponse.builder().status(false).error("401").expired(null)
		    .message(UserMessage.ACCOUNT_BLOCK).token(null).build();
	}
	if (userEntity.getRole().equals("USER")) {
	    return AuthenticationResponse.builder().status(false).error("403").expired(null)
		    .message(UserMessage.DENIED_ROLE).token(null).build();
	}
	try {
	    authenticationManager
		    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
	    long secondExpired = (System.currentTimeMillis() + 1000 * 60 * 24);
	    long dateExpired = new Date(secondExpired).getTime();
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
