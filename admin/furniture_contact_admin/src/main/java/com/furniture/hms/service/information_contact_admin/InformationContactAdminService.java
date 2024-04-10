package com.furniture.hms.service.information_contact_admin;

import com.furniture.hms.constant.InformationContactAdminMessage;
import com.furniture.hms.constant.InformationContactClientMessage;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminResponse;
import com.furniture.hms.dto.information_contact_client.InformationContactClientRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.InformationContactAdmin;
import com.furniture.hms.entity.InformationContactClient;
import com.furniture.hms.mapper.information_contact_admin.InformationContactAdminMapper;
import com.furniture.hms.mapper.information_contact_client.InformationContactClientMapper;
import com.furniture.hms.repository.information_contact_admin.InformationContactAdminRepository;
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
public class InformationContactAdminService {

    private final InformationContactAdminRepository repository;

    public ResultData<List<InformationContactAdminResponse>> getAllInformationContactAdmin() {
        List<InformationContactAdminResponse> responses = new ArrayList<>();
        InformationContactAdminResponse informationContactAdminResponse = new InformationContactAdminResponse();

        InformationContactAdmin informationContactClient = repository.findAll().stream().findFirst().orElse(null);

        if(informationContactClient != null) {
            informationContactAdminResponse = InformationContactAdminMapper.INSTANT.toInformationContactAdminResponse(informationContactClient);
            responses.add(informationContactAdminResponse);
        }
        return new ResultData<>(Boolean.TRUE, null,InformationContactAdminMessage.INFORMATION_CONTACT_ADMIN_SUCCESS,responses);
    }
}
