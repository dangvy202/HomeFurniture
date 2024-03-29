package com.furniture.hms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.WishlistOrderMessage;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderRequest;
import com.furniture.hms.service.wishlist.WishlistOrderService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class WishlistOrderController {

    private final WishlistOrderService service;

    @PostMapping("/add")
    public ResponseEntity<ResultData> addWishlistOrder(@RequestBody WishlistOrderRequest request) {
	ResultData response = service.addWishlistOrder(request);

	if (response.getMessage() == WishlistOrderMessage.SUCCESS && response.getStatus() == Boolean.TRUE) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @PatchMapping("/subtract")
    public ResponseEntity<ResultData> subtractWishlistOrder(@RequestBody WishlistOrderRequest request) {
	ResultData response = service.subtractWishlistOrder(request);

	if (response.getMessage() == WishlistOrderMessage.SUCCESS && response.getStatus() == Boolean.TRUE) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

	@PostMapping("/delete-wishlist")
	public ResponseEntity<ResultData> deleteWhenAddtocartSuccess(@RequestBody List<WishlistOrderRequest> requests) {
		ResultData response = service.deleteWhenAddtocartSuccess(requests);

		if(response.getStatus() == Boolean.TRUE) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/delete")
    public ResponseEntity<ResultData> deleteWishlistOrder(@RequestBody WishlistOrderRequest request) {
	ResultData response = service.deleteWishlistOrder(request);

	if (response.getMessage() == WishlistOrderMessage.SUCCESS && response.getStatus() == Boolean.TRUE) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResultData> getAllWishlistOrderByEmail(@PathVariable("email") String email) {
	ResultData response = service.getAllWishlistOrderByEmail(email);
	return new ResponseEntity<ResultData>(response, HttpStatus.OK);
    }
}
