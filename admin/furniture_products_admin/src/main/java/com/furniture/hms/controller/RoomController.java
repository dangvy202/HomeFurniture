package com.furniture.hms.controller;

import com.furniture.hms.dto.room.RoomResponse;
import com.furniture.hms.service.room.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms() {
        List<RoomResponse> response = roomService.getAllRooms();
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
