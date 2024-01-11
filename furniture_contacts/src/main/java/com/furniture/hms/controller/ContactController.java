package com.furniture.hms.controller;

import com.furniture.hms.constant.ContactMessage;
import com.furniture.hms.dto.contactHistory.ContactHistoryRequest;
import com.furniture.hms.dto.contactHistory.ContactHistoryResponse;
import com.furniture.hms.service.contact.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @PostMapping
    public ResponseEntity<ContactHistoryResponse> saveContact(@RequestBody ContactHistoryRequest request) {
        ContactHistoryResponse response = service.saveContactClient(request);

        if(response.getStatus() == Boolean.TRUE && response.getMessage() == ContactMessage.SUCCESS) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
