package com.furniture.hms.service.contact;

import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSRequest;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.feign.contact.InformationContactAdminCMSFeign;
import com.furniture.hms.service.spi.contact.InformationContactAdminServiceSpi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationContactAdminService implements InformationContactAdminServiceSpi {

    private final InformationContactAdminCMSFeign informationContactAdminCMSFeign;
    @Override
    public ResultData<List<InformationContactAdminCMSResponse>> getAllInformationContactAdmin() {
        ResultData<List<InformationContactAdminCMSResponse>> response = informationContactAdminCMSFeign.getAllInformationContactAdmin();
        return response;
    }

    @Override
    public ResultData<InformationContactAdminCMSResponse> updateInformationContactAdmin(InformationContactAdminCMSRequest request) {
        ResultData<InformationContactAdminCMSResponse> response = informationContactAdminCMSFeign.updateInformationContactAdmin(request);
        return response;
    }
}
