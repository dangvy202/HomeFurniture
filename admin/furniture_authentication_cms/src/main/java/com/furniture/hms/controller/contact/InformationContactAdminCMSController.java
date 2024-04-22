package com.furniture.hms.controller.contact;

import com.furniture.hms.constant.InformationContactAdminMessage;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSRequest;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.service.contact.InformationContactAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/information_contact_admin")
@RequiredArgsConstructor
public class InformationContactAdminCMSController {

    private final InformationContactAdminService informationContactAdminService;

    @GetMapping
    public ResponseEntity<ResultData<List<InformationContactAdminCMSResponse>>> getAllInformationContactAdmin() {
        var response = informationContactAdminService.getAllInformationContactAdmin();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResultData<InformationContactAdminCMSResponse>> updateInformationContactAdmin(@RequestBody InformationContactAdminCMSRequest request) {
        var response = informationContactAdminService.updateInformationContactAdmin(request);

        if(response.getStatus() == Boolean.TRUE && response.getMessage().equals(InformationContactAdminMessage.INFORMATION_CONTACT_ADMIN_SUCCESS)) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
