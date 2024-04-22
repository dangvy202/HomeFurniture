package com.furniture.hms.service.contact;

import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.contact.InformationContactClientCMSFeign;
import com.furniture.hms.service.spi.contact.InformationContactClientServiceSpi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationContactClientService implements InformationContactClientServiceSpi {

    private final InformationContactClientCMSFeign informationContactClientCMSFeign;

    @Override
    public ResultData<List<InformationContactClientCMSResponse>> getAllInformationContactClient() {
        ResultData<List<InformationContactClientCMSResponse>> response = informationContactClientCMSFeign.getAllInformationContactClient();
        return response;
    }

    @Override
    public ResultData<InformationContactClientCMSResponse> updateStatusWhenHaveContact(InformationContactClientCMSRequest request) {
        ResultData<InformationContactClientCMSResponse> response = informationContactClientCMSFeign.updateStatusWhenHaveContact(request);
        return response;
    }
}
