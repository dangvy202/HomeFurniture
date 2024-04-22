package com.furniture.hms.service.spi.contact;

import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface InformationContactClientServiceSpi {
    ResultData<List<InformationContactClientCMSResponse>> getAllInformationContactClient();

    ResultData<InformationContactClientCMSResponse> updateStatusWhenHaveContact (InformationContactClientCMSRequest request);
}
