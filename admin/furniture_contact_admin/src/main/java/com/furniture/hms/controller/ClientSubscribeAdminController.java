package com.furniture.hms.controller;

import com.furniture.hms.dto.client_subscribe.ClientSubscribeRequest;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.service.client_subscribe.ClientSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client_subscribe")
@RequiredArgsConstructor
public class ClientSubscribeAdminController {

    private final ClientSubscribeService service;

    @GetMapping
    public ResponseEntity<ResultData<List<ClientSubscribeResponse>>> getAllClientSubscribe() {
        var response = service.getAllClientSubscribe();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/status")
    public ResponseEntity<ResultData<ClientSubscribeResponse>> updateStatusClientSubscribe(@RequestBody ClientSubscribeRequest request) {
        var response = service.updateStatusClientSubscribe(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
