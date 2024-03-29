package com.furniture.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderResponse;
import com.furniture.hms.service.wishlist.WishlistOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistAdminController {

    private final WishlistOrderService wishlistService;

    @GetMapping
    public ResponseEntity<ResultData<List<WishlistOrderResponse>>> getAllWishlist() {
	var response = wishlistService.getAllWishlistOrder();
	return new ResponseEntity<ResultData<List<WishlistOrderResponse>>>(response, HttpStatus.OK);
    }
}
