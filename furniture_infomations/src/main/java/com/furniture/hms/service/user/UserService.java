package com.furniture.hms.service.user;

import com.furniture.hms.constant.UserMessage;
import com.furniture.hms.dto.auth.AuthenticationRequest;
import com.furniture.hms.dto.auth.AuthenticationResponse;
import com.furniture.hms.dto.user.UserRequest;
import com.furniture.hms.dto.user.UserResponse;
import com.furniture.hms.entity.User;
import com.furniture.hms.mapper.user.UserMapper;
import com.furniture.hms.repository.user.UserRepository;
import com.furniture.hms.security.UserDetail;
import com.furniture.hms.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @Transactional
    public UserResponse registerAccount(UserRequest userRequest){
        UserResponse userResponse = new UserResponse();
        try{
            //check mail
            User userCheck = userRepository.findUserByEmail(userRequest.getEmail());
            if(userCheck != null){
                userResponse.setStatus(false);
                userResponse.setError(UserMessage.FAIL);
                userResponse.setMessage(UserMessage.EMAIL_EXIST);
                return userResponse;
            }else {
                Instant createDate = Instant.now();
                Instant updateDate = Instant.now();
                Date dateFormat = new SimpleDateFormat("yyyy-MM-dd").parse(userRequest.getBirthday());
                String password = bCryptPasswordEncoder.encode(userRequest.getPassword());
                User user = userRepository.save(UserMapper.INSTANCE.toUserEntity(userRequest,createDate,updateDate,dateFormat,password));
                User userDetail = userRepository.findById(user.getId()).orElse(null);
                if(userDetail != null){
                    UserResponse.DataUser userData = UserMapper.INSTANCE.toUserRes(userDetail);
                    userResponse.setStatus(true);
                    userResponse.setError(null);
                    userResponse.setMessage(UserMessage.SUCCESS);
                    userResponse.setUser(userData);
                    return userResponse;
                }else {
                    userResponse.setStatus(true);
                    userResponse.setError(UserMessage.NOT_FOUND);
                    userResponse.setMessage(UserMessage.NOT_FOUND);
                    return userResponse;
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            userResponse.setStatus(false);
            userResponse.setError(UserMessage.FAIL);
            userResponse.setMessage(UserMessage.FAIL);
            return userResponse;
        }
    }

    public UserResponse getInfomation(String request){
        UserResponse userResponse = new UserResponse();
        User userCheck = userRepository.findUserByEmail(request);
        if(userCheck != null){
            userResponse.setStatus(true);
            userResponse.setError(null);
            userResponse.setMessage(UserMessage.SUCCESS);
            userResponse.setUser(UserMapper.INSTANCE.toUserRes(userCheck));
            return userResponse;
        }else {
            userResponse.setStatus(false);
            userResponse.setError(UserMessage.NOT_FOUND);
            userResponse.setMessage(UserMessage.NOT_FOUND);
            return userResponse;
        }
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        var userEntity = userRepository.findUserByEmail(request.getEmail());
        if(userEntity == null){
            return AuthenticationResponse.builder()
                    .status(false)
                    .error("403")
                    .expired(null)
                    .message(UserMessage.FAIL)
                    .token(null)
                    .build();
        }
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            UserDetail userDetail = new UserDetail(userEntity);
            var jwtToken = jwtService.generateToken(userDetail);
            return AuthenticationResponse.builder()
                    .status(true)
                    .error(null)
                    .expired("asd")
                    .message(UserMessage.SUCCESS)
                    .token(jwtToken)
                    .build();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return AuthenticationResponse.builder()
                    .status(false)
                    .error("403")
                    .expired(null)
                    .message(UserMessage.BAD_CREDENTIALES)
                    .token(null)
                    .build();
        }
    }
}
