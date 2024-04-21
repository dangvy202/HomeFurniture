package com.furniture.hms.controller.contact;

import com.furniture.hms.constant.ContactHistoryMessage;
import com.furniture.hms.dto.contact_history.ContactHistoryCMSRequest;
import com.furniture.hms.dto.contact_history.ContactHistoryCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.service.contact.ContactClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/contact_client")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class ContactClientCMSController {

    private final ContactClientService contactClientService;

    @GetMapping
    public ResponseEntity<ResultData<List<ContactHistoryCMSResponse>>> getAllContactClient() {
        var response = contactClientService.getAllContactClient();
        if(response.getStatus() == Boolean.TRUE && response.getMessage().equals(ContactHistoryMessage.CONTACT_HISTORY_SUCCESS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/update/process")
    public ResponseEntity<ResultData<ContactHistoryCMSResponse>> updateProcess(@RequestBody ContactHistoryCMSRequest request) {
        var response = contactClientService.updateProcess(request);
        if(response.getStatus() == Boolean.TRUE && response.getMessage().equals(ContactHistoryMessage.CONTACT_HISTORY_SUCCESS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResultData<ContactHistoryCMSResponse>> deleteByProcess(@RequestBody ContactHistoryCMSRequest request) {
        var response = contactClientService.deleteByProcess(request);
        if(response.getStatus() == Boolean.TRUE && response.getMessage().equals(ContactHistoryMessage.CONTACT_HISTORY_SUCCESS)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
