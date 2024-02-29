package com.furniture.hms.controller;

import com.furniture.hms.dto.showroom.ShowroomResponse;
import com.furniture.hms.service.showroom.ShowroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showroom")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class ShowroomController {

    private final ShowroomService service;

    @GetMapping
    public ResponseEntity<ShowroomResponse> getShowroom() {
        ShowroomResponse response = service.getShowroom();

        if(response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
