package com.furniture.hms.service.spi.contact;

import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSRequest;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public interface InformationContactAdminServiceSpi {

    ResultData<List<InformationContactAdminCMSResponse>> getAllInformationContactAdmin();

    ResultData<InformationContactAdminCMSResponse> updateInformationContactAdmin(InformationContactAdminCMSRequest request);

}
