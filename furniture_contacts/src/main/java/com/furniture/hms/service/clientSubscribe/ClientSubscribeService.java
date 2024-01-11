package com.furniture.hms.service.clientSubscribe;

import com.furniture.hms.constant.ClientSubscribeMessage;
import com.furniture.hms.dto.clientSubscribe.ClientSubscribeRequest;
import com.furniture.hms.dto.clientSubscribe.ClientSubscribeResponse;
import com.furniture.hms.entity.ClientSubscribe;
import com.furniture.hms.enums.CheckMailEnum;
import com.furniture.hms.mapper.clientSubscribe.ClientSubscribeMapper;
import com.furniture.hms.mapper.clientSubscribe.ClientSubscribeMapperImpl;
import com.furniture.hms.repository.clientSubscribe.ClientSubscribeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientSubscribeService {

    private final ClientSubscribeRepository repository;

    public ClientSubscribeResponse subscribe(ClientSubscribeRequest request) {

        ClientSubscribeResponse response = new ClientSubscribeResponse();

        ClientSubscribe clientSubscribe = repository.findByEmailContaining(request.getEmail()).orElse(null);

        if(!StringUtils.isEmpty(request.getEmail())) {
            if(clientSubscribe == null) {
                response.setError(null);
                response.setMessage(ClientSubscribeMessage.SUBSCRIBE_SUCCESS);
                response.setStatus(Boolean.TRUE);
                response.setClientSubscribeDetail(null);
                repository.save(ClientSubscribeMapper.INSTANCE.toClientEntity(request.getEmail(), CheckMailEnum.INVALID , Instant.now()));
                return response;
            } else {
                response.setError(ClientSubscribeMessage.SUBSCRIBE_FAIL);
                response.setMessage(ClientSubscribeMessage.SUBSCRIBE_EXIST);
                response.setStatus(Boolean.FALSE);
                response.setClientSubscribeDetail(null);
                return response;
            }
        } else {
            response.setError(ClientSubscribeMessage.SUBSCRIBE_FAIL);
            response.setMessage(ClientSubscribeMessage.SUBSCRIBE_EMPTY);
            response.setStatus(Boolean.FALSE);
            response.setClientSubscribeDetail(null);
            return response;
        }
    }
}
