package com.furniture.hms.service.contact;

import com.furniture.hms.dto.contact_history.ContactHistoryCMSRequest;
import com.furniture.hms.dto.contact_history.ContactHistoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.contact.ContactClientCMSFeign;
import com.furniture.hms.service.spi.contact.ContactClientServiceSpi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContactClientService implements ContactClientServiceSpi {

    private final ContactClientCMSFeign contactClientCMSFeign;

    @Override
    public ResultData<List<ContactHistoryCMSResponse>> getAllContactClient() {
        ResultData<List<ContactHistoryCMSResponse>> response = contactClientCMSFeign.getAllContactClient();
        return response;
    }

    @Override
    public ResultData<ContactHistoryCMSResponse> updateProcess(ContactHistoryCMSRequest request) {
        ResultData<ContactHistoryCMSResponse> response = contactClientCMSFeign.updateProcess(request);
        return response;
    }

    @Override
    public ResultData<ContactHistoryCMSResponse> deleteByProcess(ContactHistoryCMSRequest request) {
        ResultData<ContactHistoryCMSResponse> response = contactClientCMSFeign.deleteByProcess(request);
        return response;
    }
}
