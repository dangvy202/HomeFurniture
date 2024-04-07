package com.furniture.hms.service.information_contact_client;

import com.furniture.hms.constant.InformationContactClientMessage;
import com.furniture.hms.dto.information_contact_client.InformationContactClientRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.InformationContactClient;
import com.furniture.hms.mapper.information_contact_client.InformationContactClientMapper;
import com.furniture.hms.repository.information_contact_client.InformationContactClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationContactClientService {

    private final InformationContactClientRepository repository;

    public ResultData<List<InformationContactClientResponse>> getAllInformationContactClient() {
        List<InformationContactClientResponse> response = new ArrayList<>();

        List<InformationContactClient> informationContactClientList = repository.findAll();

        if(!CollectionUtils.isEmpty(informationContactClientList)) {
            informationContactClientList.forEach(informationContactClient -> {
                InformationContactClientResponse informationContactClientResponse =
                        InformationContactClientMapper.INSTANCE
                                .toInformationContactClientResponse(informationContactClient);
                response.add(informationContactClientResponse);
            });
        }
        return new ResultData<>(Boolean.TRUE,null, InformationContactClientMessage.INFORMATION_CONTACT_CLIENT_SUCCESS,response);
    }

    public ResultData<InformationContactClientResponse> updateStatusWhenHaveContact(InformationContactClientRequest request) {
        InformationContactClient informationContactClient = repository.findById(request.getId()).orElse(null);

        InformationContactClientResponse response = new InformationContactClientResponse();
        try {
            if(informationContactClient != null) {
                informationContactClient.setStatus(1);
                repository.save(informationContactClient);
                response = InformationContactClientMapper.INSTANCE.toInformationContactClientResponse(informationContactClient);
                return new ResultData<>(Boolean.TRUE,null,InformationContactClientMessage.INFORMATION_CONTACT_CLIENT_SUCCESS,response);
            }
        } catch (Exception ex) {
            return new ResultData<>(Boolean.FALSE, InformationContactClientMessage.INFORMATION_CONTACT_CLIENT_FAIL, ex.getMessage(),response);
        }
        return new ResultData<>(Boolean.FALSE, InformationContactClientMessage.INFORMATION_CONTACT_CLIENT_FAIL, InformationContactClientMessage.INFORMATION_CONTACT_CLIENT_NOT_EXIST,response);
    }
}
