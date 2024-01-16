package com.furniture.hms.service.contact;

import com.furniture.hms.constant.ContactMessage;
import com.furniture.hms.dto.contactDescription.ContactDescriptionRequest;
import com.furniture.hms.dto.contactHistory.ContactHistoryRequest;
import com.furniture.hms.dto.contactHistory.ContactHistoryResponse;
import com.furniture.hms.dto.informationContactClient.InformationContactClientRequest;
import com.furniture.hms.entity.ContactDescription;
import com.furniture.hms.entity.ContactHistory;
import com.furniture.hms.entity.InformationContactClient;
import com.furniture.hms.enums.ProcessEnum;
import com.furniture.hms.mapper.contactDescription.ContactDescriptionMapper;
import com.furniture.hms.mapper.contactHistory.ContactHistoryMapper;
import com.furniture.hms.mapper.informationContactClient.InformationContactClientMapper;
import com.furniture.hms.repository.contactDescription.ContactDescriptionRepository;
import com.furniture.hms.repository.contactHistory.ContactHistoryRepository;
import com.furniture.hms.repository.informationContactClient.InformationContactClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactService {

    private final ContactDescriptionRepository contactDescriptionRepository;

    private final InformationContactClientRepository informationContactClientRepository;

    private final ContactHistoryRepository contactHistoryRepository;

    @Transactional
    public ContactHistoryResponse saveContactClient(ContactHistoryRequest request) {
        ContactDescriptionRequest contactDescriptionRequest = request.getContactDescriptionDetail().getContactDescriptionRequest();
        InformationContactClientRequest informationContactClientRequest = request.getInformationContactClientDetail().getInformationContactClientRequest();

        ContactHistoryResponse response = new ContactHistoryResponse();

        if(contactDescriptionRequest.getDescription() != null ||
                contactDescriptionRequest.getTitle() != null ||
                informationContactClientRequest.getEmail() != null ||
                informationContactClientRequest.getPhone() != null ||
                informationContactClientRequest.getAddress() != null
        ) {
            try{
                Instant dateNow = Instant.now();
                InformationContactClient informationContactClientEntity = InformationContactClientMapper.INSTANT.toInformationContactClientEntity(informationContactClientRequest,dateNow,request.getInformationContactClientDetail().getInformationContactClientRequest().getName(),0);
                ContactDescription contactDescriptionEntity = ContactDescriptionMapper.INSTANCE.toContactDescriptionEntity(contactDescriptionRequest, dateNow);
                ContactHistory contactHistoryEntity =
                        ContactHistoryMapper.INSTANT.toContactHistoryEntity(
                            request.getProcess(),
                            request.getMessage(),
                            informationContactClientEntity,
                            contactDescriptionEntity,
                            informationContactClientRequest.getEmail(),
                            dateNow,
                            informationContactClientRequest.getEmail(),
                            dateNow
                        );
                informationContactClientRepository.save(informationContactClientEntity);
                contactDescriptionRepository.save(contactDescriptionEntity);
                contactHistoryRepository.save(contactHistoryEntity);
                response = ContactHistoryMapper.INSTANT.toContactHistoryResponse(
                        Boolean.TRUE ,null, ContactMessage.SUCCESS
                );
                return response;
            } catch (Exception ex) {
                log.error(ex.getMessage());
                response = ContactHistoryMapper.INSTANT.toContactHistoryResponse(
                        Boolean.FALSE ,null, ContactMessage.FAIL
                );
                return response;
            }
        } else {
            response = ContactHistoryMapper.INSTANT.toContactHistoryResponse(
                    Boolean.FALSE ,null, ContactMessage.NULL_PARAMETER
            );
            return response;
        }
    }
}
