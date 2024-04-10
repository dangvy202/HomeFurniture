package com.furniture.hms.service.information_contact_admin;

import com.furniture.hms.constant.InformationContactAdminMessage;
import com.furniture.hms.constant.InformationContactClientMessage;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminRequest;
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

import java.time.Instant;
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

    public ResultData<InformationContactAdminResponse> updateInformationContactAdmin(InformationContactAdminRequest request) {
        InformationContactAdmin informationContactAdmin = repository.findById(request.getId()).orElse(null);
        try {
            if(informationContactAdmin != null) {
                informationContactAdmin.setEmail(request.getEmail());
                informationContactAdmin.setAddress(request.getAddress());
                informationContactAdmin.setHotline(request.getHotline());
                informationContactAdmin.setUpdateDate(Instant.now());
                repository.save(informationContactAdmin);
                return new ResultData<>(Boolean.TRUE,null,InformationContactAdminMessage.INFORMATION_CONTACT_ADMIN_SUCCESS,null);
            }
        } catch (Exception ex){
            return new ResultData<>(Boolean.FALSE,InformationContactAdminMessage.INFORMATION_CONTACT_ADMIN_FAIL, ex.getMessage(), null);
        }
        return new ResultData<>(Boolean.FALSE,InformationContactAdminMessage.INFORMATION_CONTACT_ADMIN_FAIL,InformationContactAdminMessage.INFORMATION_CONTACT_ADMIN_NOT_EXIST , null);
    }
}
