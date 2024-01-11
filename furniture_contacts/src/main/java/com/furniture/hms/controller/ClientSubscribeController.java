package com.furniture.hms.controller;

import com.furniture.hms.dto.clientSubscribe.ClientSubscribeRequest;
import com.furniture.hms.dto.clientSubscribe.ClientSubscribeResponse;
import com.furniture.hms.mapper.clientSubscribe.ClientSubscribeMapper;
import com.furniture.hms.service.clientSubscribe.ClientSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client-subscribe")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ClientSubscribeController {

    private final ClientSubscribeService clientSubscribeService;

    @PostMapping
    public ResponseEntity<ClientSubscribeResponse> subscribeEmail(@RequestBody ClientSubscribeRequest request) {
        ClientSubscribeResponse response = clientSubscribeService.subscribe(request);
        if(response.getStatus() == Boolean.TRUE) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
