package com.furniture.hms.service.spi.contact;

import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSRequest;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface ClientSubscribeServiceSpi {
    ResultData<List<ClientSubscribeCMSResponse>> getAllClientSubscribe();

    ResultData<ClientSubscribeCMSResponse> updateStatusClientSubscribe(ClientSubscribeCMSRequest request);

    ResultData<ClientSubscribeCMSResponse> deleteClientSubscribe(ClientSubscribeCMSRequest request);

}
