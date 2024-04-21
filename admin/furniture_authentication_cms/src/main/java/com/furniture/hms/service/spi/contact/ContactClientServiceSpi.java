package com.furniture.hms.service.spi.contact;

import com.furniture.hms.dto.contact_history.ContactHistoryCMSRequest;
import com.furniture.hms.dto.contact_history.ContactHistoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface ContactClientServiceSpi {
    ResultData<List<ContactHistoryCMSResponse>> getAllContactClient();

    ResultData<ContactHistoryCMSResponse> updateProcess(@RequestBody ContactHistoryCMSRequest request);

    ResultData<ContactHistoryCMSResponse> deleteByProcess(@RequestBody ContactHistoryCMSRequest request);

}
