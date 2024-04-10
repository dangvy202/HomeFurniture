package com.furniture.hms.controller;

import com.furniture.hms.dto.information_contact_admin.InformationContactAdminRequest;
import com.furniture.hms.dto.information_contact_admin.InformationContactAdminResponse;
import com.furniture.hms.dto.information_contact_client.InformationContactClientRequest;
import com.furniture.hms.dto.information_contact_client.InformationContactClientResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.information_contact_admin.InformationContactAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/information_contact_admin")
@RequiredArgsConstructor
public class InformationContactAdminAdminController {

    private final InformationContactAdminService service;

    @GetMapping
    public ResponseEntity<ResultData<List<InformationContactAdminResponse>>> getAllInformationContactAdmin() {
        var response = service.getAllInformationContactAdmin();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResultData<InformationContactAdminResponse>> updateInformationContactAdmin(@RequestBody InformationContactAdminRequest request) {
        var response = service.updateInformationContactAdmin(request);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
