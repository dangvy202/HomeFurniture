package com.furniture.hms.service.contact_client;

import com.furniture.hms.constant.ContactDescriptionMessage;
import com.furniture.hms.constant.ContactHistoryMessage;
import com.furniture.hms.constant.InformationContactClientMessage;
import com.furniture.hms.dto.contact_history.ContactHistoryRequest;
import com.furniture.hms.dto.contact_history.ContactHistoryResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.ContactDescription;
import com.furniture.hms.entity.ContactHistory;
import com.furniture.hms.entity.InformationContactClient;
import com.furniture.hms.mapper.contact_history.ContactHistoryMapper;
import com.furniture.hms.repository.contact_description.ContactDescriptionRepository;
import com.furniture.hms.repository.contact_history.ContactHistoryRepository;
import com.furniture.hms.repository.information_contact_client.InformationContactClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactClientService {

    private final ContactHistoryRepository contactHistoryRepository;

    private final ContactDescriptionRepository contactDescriptionRepository;

    private final InformationContactClientRepository informationContactClientRepository;

    public ResultData<List<ContactHistoryResponse>> getAllContactClient() {
        List<ContactHistoryResponse> responses = new ArrayList<>();

        List<ContactHistory> contactHistoryList = contactHistoryRepository.findAll();

        String msg = "";

        if(!CollectionUtils.isEmpty(contactHistoryList)) {
            for(ContactHistory contactHistory : contactHistoryList) {
                ContactDescription contactDescription = contactDescriptionRepository.findById(contactHistory.getContactDescription().getId()).orElse(null);
                InformationContactClient informationContactClient = informationContactClientRepository.findById(contactHistory.getInformationContactClient().getId()).orElse(null);

                if(contactDescription != null && informationContactClient != null) {
                    ContactHistoryResponse contactHistoryResponse = new ContactHistoryResponse();
                    Map<String, Object> other = new HashMap<String, Object>();
                    other.put("contact_description" , contactDescription);
                    other.put("information_contact_client" , informationContactClient);
                    contactHistoryResponse = ContactHistoryMapper.INSTANCE.toContactHistoryResponse(contactHistory,other);

                    responses.add(contactHistoryResponse);
                }
                else {
                    responses.clear();
                    msg = contactDescription == null ? ContactDescriptionMessage.CONTACT_DESCRIPTION_NOT_EXIST : InformationContactClientMessage.INFORMATION_CONTACT_CLIENT_NOT_EXIST;
                    return new ResultData<List<ContactHistoryResponse>>(Boolean.FALSE,msg,msg,responses);
                }
            };
            return new ResultData<List<ContactHistoryResponse>>(Boolean.TRUE,null, ContactHistoryMessage.CONTACT_HISTORY_SUCCESS,responses);
        }
        return new ResultData<List<ContactHistoryResponse>>(Boolean.FALSE,"msg","msg",responses);
    }

    public ResultData<ContactHistoryResponse> updateProcess(ContactHistoryRequest request) {
        ContactHistoryResponse response = new ContactHistoryResponse();
        ContactHistory contactHistory = contactHistoryRepository.findById(request.getId()).orElse(null);
        try{
            if(contactHistory != null) {
                contactHistory.setProcess(request.getProcess());
                contactHistoryRepository.save(contactHistory);
                response = ContactHistoryMapper.INSTANCE.toContactHistoryResponse(contactHistory,null);
                return new ResultData<>(Boolean.TRUE,null,ContactHistoryMessage.CONTACT_HISTORY_SUCCESS,response);
            }
        } catch (Exception ex) {
            return new ResultData<>(Boolean.FALSE,ContactHistoryMessage.CONTACT_HISTORY_FAIL, ex.getMessage(), response);
        }
        return new ResultData<>(Boolean.FALSE,ContactHistoryMessage.CONTACT_HISTORY_FAIL, ContactHistoryMessage.CONTACT_HISTORY_NOT_EXIST, response);
    }

    @Transactional
    public ResultData<ContactHistoryResponse> deleteByProcess(ContactHistoryRequest request) {
        ContactHistory contactHistory = contactHistoryRepository.findById(request.getId()).orElse(null);

        if(contactHistory != null) {
            //delete
            contactHistoryRepository.deleteById(contactHistory.getId());
            contactDescriptionRepository.deleteById(contactHistory.getContactDescription().getId());
            informationContactClientRepository.deleteById(contactHistory.getInformationContactClient().getId());
            return new ResultData<>(Boolean.TRUE,null,ContactHistoryMessage.CONTACT_HISTORY_SUCCESS,null);
        }
        return new ResultData<>(Boolean.FALSE,ContactHistoryMessage.CONTACT_HISTORY_FAIL,ContactHistoryMessage.CONTACT_HISTORY_NOT_EXIST,null);
    }

}
