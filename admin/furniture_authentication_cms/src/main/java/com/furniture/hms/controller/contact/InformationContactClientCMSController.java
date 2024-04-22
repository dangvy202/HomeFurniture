package com.furniture.hms.controller.contact;

import com.furniture.hms.constant.InformationContactClientMessage;
import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.service.contact.InformationContactClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/information_contact_client")
@RequiredArgsConstructor
public class InformationContactClientCMSController {

    private final InformationContactClientService informationContactClientService;

    @GetMapping
    public ResponseEntity<ResultData<List<InformationContactClientCMSResponse>>> getAllInformationContactClient() {
        var response = informationContactClientService.getAllInformationContactClient();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/status")
    public ResponseEntity<ResultData<InformationContactClientCMSResponse>> updateStatusWhenHaveContact (@RequestBody InformationContactClientCMSRequest request) {
        var response = informationContactClientService.updateStatusWhenHaveContact(request);

        if(response.getStatus() == Boolean.TRUE && response.getMessage().equals(InformationContactClientMessage.INFORMATION_CONTACT_CLIENT_SUCCESS)) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        }

        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
