package com.furniture.hms.service.contact_client;

import com.furniture.hms.dto.contact_history.ContactHistoryResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.ContactDescription;
import com.furniture.hms.entity.ContactHistory;
import com.furniture.hms.repository.contact_description.ContactDescriptionRepository;
import com.furniture.hms.repository.contact_history.ContactHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactClientService {

    private final ContactHistoryRepository contactHistoryRepository;

    private final ContactDescriptionRepository contactDescriptionRepository;

    public ResultData<List<ContactHistoryResponse>> getAllContactClient() {
        return null;
    }

}
