package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.constant.WishlistOrderMessage;
import com.furniture.hms.dto.wishlist.WishlistOrderRequest;
import com.furniture.hms.dto.wishlist.WishlistOrderResponse;
import com.furniture.hms.service.wishlist.WishlistOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class WishlistOrderController {

    private final WishlistOrderService service;

    @PostMapping("/add")
    public ResponseEntity<WishlistOrderResponse> addWishlistOrder(@RequestBody WishlistOrderRequest request) {
	WishlistOrderResponse response = service.addWishlistOrder(request);

	if (response.getMessage() == WishlistOrderMessage.SUCCESS && response.getStatus() == Boolean.TRUE) {
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<WishlistOrderResponse>> getAllWishlistOrderByEmail(@PathVariable("email") String email) {
	List<WishlistOrderResponse> response = service.getAllWishlistOrderByEmail(email);
	return new ResponseEntity<List<WishlistOrderResponse>>(response, HttpStatus.OK);
    }
}
