package com.furniture.hms.controller;

import com.furniture.hms.constant.ContactMessage;
import com.furniture.hms.dto.contactHistory.ContactHistoryRequest;
import com.furniture.hms.dto.contactHistory.ContactHistoryResponse;
import com.furniture.hms.dto.informationContactAdmin.InformationContactAdminResponse;
import com.furniture.hms.service.contact.ContactService;
import com.furniture.hms.service.informationContactAdmin.InformationContactAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ContactController {

    private final ContactService contactservice;

    private final InformationContactAdminService informationContactAdminService;

    @PostMapping
    public ResponseEntity<ContactHistoryResponse> saveContact(@RequestBody ContactHistoryRequest request) {
        ContactHistoryResponse response = contactservice.saveContactClient(request);

        if(response.getStatus() == Boolean.TRUE && response.getMessage() == ContactMessage.SUCCESS) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/information/admin")
    public ResponseEntity<InformationContactAdminResponse> getInformationAdmin() {

        InformationContactAdminResponse response = informationContactAdminService.getInformationAdmin();

        if(response.getInformationContactAdminDetailList() != null ) {
            return new ResponseEntity<>(response,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
