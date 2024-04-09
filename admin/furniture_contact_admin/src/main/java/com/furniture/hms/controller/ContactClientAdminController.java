package com.furniture.hms.controller;


import com.furniture.hms.dto.contact_history.ContactHistoryRequest;
import com.furniture.hms.dto.contact_history.ContactHistoryResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.contact_client.ContactClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact_client")
@RequiredArgsConstructor
public class ContactClientAdminController {

    private final ContactClientService service;

    @GetMapping
    public ResponseEntity<ResultData<List<ContactHistoryResponse>>> getAllContactClient() {
        var response = service.getAllContactClient();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/process")
    public ResponseEntity<ResultData<ContactHistoryResponse>> updateProcess(@RequestBody ContactHistoryRequest request) {
        var response = service.updateProcess(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResultData<ContactHistoryResponse>> deleteByProcess(@RequestBody ContactHistoryRequest request) {
        var response = service.deleteByProcess(request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
