package com.furniture.hms.service.contact;

import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSRequest;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.contact.ClientSubscribeCMSFeign;
import com.furniture.hms.service.spi.contact.ClientSubscribeServiceSpi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientSubscribeService implements ClientSubscribeServiceSpi {

    private final ClientSubscribeCMSFeign clientSubscribeCMSFeign;

    @Override
    public ResultData<List<ClientSubscribeCMSResponse>> getAllClientSubscribe() {
        ResultData<List<ClientSubscribeCMSResponse>> response = clientSubscribeCMSFeign.getAllClientSubscribe();
        return response;
    }

    @Override
    public ResultData<ClientSubscribeCMSResponse> updateStatusClientSubscribe(ClientSubscribeCMSRequest request) {
        ResultData<ClientSubscribeCMSResponse> response = clientSubscribeCMSFeign.updateStatusClientSubscribe(request);
        return response;
    }

    @Override
    public ResultData<ClientSubscribeCMSResponse> deleteClientSubscribe(ClientSubscribeCMSRequest request) {
        ResultData<ClientSubscribeCMSResponse> response = clientSubscribeCMSFeign.deleteClientSubscribe(request);
        return response;
    }
}
