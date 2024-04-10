package com.furniture.hms.controller;

import com.furniture.hms.dto.information_contact_client.InformationContactClientRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.information_contact_client.InformationContactClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information_contact_client")
@RequiredArgsConstructor
public class InformationContactAdminAdminController {

    private final InformationContactClientService service;

    @GetMapping
    public ResponseEntity<ResultData<List<InformationContactClientResponse>>> getAllInformationContactClient() {
        var response = service.getAllInformationContactClient();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/update/status")
    public ResponseEntity<ResultData<InformationContactClientResponse>> updateStatusWhenHaveContact (@RequestBody InformationContactClientRequest request) {
        var response = service.updateStatusWhenHaveContact(request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
