package com.furniture.hms.controller;

import com.furniture.hms.dto.information_contact_client.InformationContactClientResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.information_contact_client.InformationContactClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/information_contact_client")
@RequiredArgsConstructor
public class InformationContactClientAdminController {

    private final InformationContactClientService service;

    @GetMapping
    public ResponseEntity<ResultData<List<InformationContactClientResponse>>> getAllInformationContactClient() {
        var response = service.getAllInformationContactClient();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
