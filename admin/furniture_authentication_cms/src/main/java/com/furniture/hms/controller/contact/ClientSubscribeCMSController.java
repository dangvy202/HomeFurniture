package com.furniture.hms.controller.contact;

import com.furniture.hms.constant.ClientSubscribeMessage;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSRequest;
import com.furniture.hms.dto.client_subscribe.ClientSubscribeCMSResponse;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.service.contact.ClientSubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/client_subscribe")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class ClientSubscribeCMSController {

    private final ClientSubscribeService clientSubscribeService;

    @GetMapping
    public ResponseEntity<ResultData<List<ClientSubscribeCMSResponse>>> getAllClientSubscribe() {
        var response = clientSubscribeService.getAllClientSubscribe();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/status")
    public ResponseEntity<ResultData<ClientSubscribeCMSResponse>> updateStatusClientSubscribe(@RequestBody ClientSubscribeCMSRequest request) {
        var response = clientSubscribeService.updateStatusClientSubscribe(request);

        if(response.getStatus() == Boolean.TRUE && response.getMessage().equals(ClientSubscribeMessage.SUBSCRIBE_SUCCESS)) {
            return new ResponseEntity<ResultData<ClientSubscribeCMSResponse>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<ResultData<ClientSubscribeCMSResponse>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResultData<ClientSubscribeCMSResponse>> deleteClientSubscribe(@RequestBody ClientSubscribeCMSRequest request) {
        var response = clientSubscribeService.deleteClientSubscribe(request);

        if(response.getStatus() == Boolean.TRUE && response.getMessage().equals(ClientSubscribeMessage.SUBSCRIBE_SUCCESS)) {
            return new ResponseEntity<ResultData<ClientSubscribeCMSResponse>>(response,HttpStatus.OK);
        }

        return new ResponseEntity<ResultData<ClientSubscribeCMSResponse>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
