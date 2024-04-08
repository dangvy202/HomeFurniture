package com.furniture.hms.controller;


import com.furniture.hms.dto.contact_history.ContactHistoryResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.contact_client.ContactClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/information_contact_client")
@RequiredArgsConstructor
public class ContactClientAdminController {

    private final ContactClientService service;

    public ResponseEntity<ResultData<List<ContactHistoryResponse>>> getAllContactClient() {
        var response = service.getAllContactClient();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
