package com.furniture.hms.service.login;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import org.springframework.data.redis.core.RedisTemplate;
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

	private final RedisTemplate<String , String> redisTemplate;

	public AuthenticationResponse getTokenInRedis(String keyRedis) {
		String tokenRedis = redisTemplate.opsForValue().get(keyRedis);
		long expired = redisTemplate.getExpire(keyRedis);
		long timeNow = System.currentTimeMillis();

		if(timeNow > expired) {
			redisTemplate.delete(keyRedis);
			return AuthenticationResponse.builder().status(false).error("403").expired(null)
					.message(UserMessage.EXPIRED_USER).token(null).build();
		}
		else if (tokenRedis.isEmpty() ) {
			return AuthenticationResponse.builder().status(false).error("403").expired(null)
					.message(UserMessage.NOT_FOUND_TOKEN).token(null).build();
		} else{
			return AuthenticationResponse.builder().status(true).error(null).expired(String.valueOf(expired))
					.message(UserMessage.SUCCESS).token(tokenRedis).build();
		}
	}

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
	    String jwtToken = jwtService.generateToken(userDetail);
		String keyRedis = UUID.randomUUID().toString();
		//save token into redis
		redisTemplate.opsForValue().set(keyRedis,jwtToken,dateExpired,TimeUnit.MILLISECONDS);
		return getTokenInRedis(keyRedis);
	} catch (Exception ex) {
	    log.error(ex.getMessage());
	    return AuthenticationResponse.builder().status(false).error("403").expired(null)
		    .message(UserMessage.BAD_CREDENTIALES).token(null).build();
	}
    }
}
