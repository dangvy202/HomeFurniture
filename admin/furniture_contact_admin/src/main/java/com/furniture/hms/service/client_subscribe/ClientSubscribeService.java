package com.furniture.hms.service.client_subscribe;

import com.furniture.hms.constant.ClientSubscribeMessage;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeRequest;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.ClientSubscribe;
import com.furniture.hms.mapper.client_subscribe.ClientSubscribeMapper;
import com.furniture.hms.repository.client_subscribe.ClientSubscribeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientSubscribeService {

    private final ClientSubscribeRepository repository;

    public ResultData<List<ClientSubscribeResponse>> getAllClientSubscribe() {
        List<ClientSubscribeResponse> responses = new ArrayList<>();

        List<ClientSubscribe> clientSubscribeList = repository.findAll();

        if (!CollectionUtils.isEmpty(clientSubscribeList)) {
            for(ClientSubscribe clientSubscribe : clientSubscribeList) {
                ClientSubscribeResponse clientSubscribeResponse = new ClientSubscribeResponse();
                clientSubscribeResponse = ClientSubscribeMapper.INSTANCE.toClientSubscribeResponse(clientSubscribe);
                responses.add(clientSubscribeResponse);
            }
        }
        return new ResultData<>(Boolean.TRUE,null, ClientSubscribeMessage.SUBSCRIBE_SUCCESS,responses);
    }

    public ResultData<ClientSubscribeResponse> updateStatusClientSubscribe(ClientSubscribeRequest request) {
        ClientSubscribe clientSubscribe = repository.findById(request.getId()).orElse(null);
        try{
            if(clientSubscribe != null ) {
                clientSubscribe.setCheckMail(request.getCheckMail());
                clientSubscribe.setCreateDate(Instant.now());
                repository.save(clientSubscribe);
                return new ResultData<>(Boolean.TRUE,null,ClientSubscribeMessage.SUBSCRIBE_SUCCESS,null);
            }
        } catch (Exception ex) {
            return new ResultData<>(Boolean.FALSE,ClientSubscribeMessage.SUBSCRIBE_FAIL, ex.getMessage(), null);
        }
        return new ResultData<>(Boolean.FALSE,ClientSubscribeMessage.SUBSCRIBE_FAIL, ClientSubscribeMessage.SUBSCRIBE_NOT_EXIST, null);
    }

    public ResultData<ClientSubscribeResponse> deleteClientSubscribe(ClientSubscribeRequest request) {
        ClientSubscribeResponse response = new ClientSubscribeResponse();
        ClientSubscribe clientSubscribe = repository.findById(request.getId()).orElse(null);
        try{
            if(clientSubscribe != null) {
                response = ClientSubscribeMapper.INSTANCE.toClientSubscribeResponse(clientSubscribe);
                repository.delete(clientSubscribe);
                return new ResultData<>(Boolean.TRUE,null, ClientSubscribeMessage.SUBSCRIBE_SUCCESS, response);
            }
        } catch (Exception ex) {
            return new ResultData<>(Boolean.FALSE,ClientSubscribeMessage.SUBSCRIBE_FAIL, ex.getMessage(), response);
        }
        return new ResultData<>(Boolean.FALSE,ClientSubscribeMessage.SUBSCRIBE_FAIL,ClientSubscribeMessage.SUBSCRIBE_NOT_EXIST,response);
    }
}
