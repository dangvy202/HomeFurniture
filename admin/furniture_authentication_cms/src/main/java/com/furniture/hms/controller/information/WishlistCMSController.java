package com.furniture.hms.controller.information;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderCMSResponse;
import com.furniture.hms.service.information.WishlistOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/wishlist")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:9000")
public class WishlistCMSController {

    private final WishlistOrderService wishlistOrderService;

    @GetMapping
    public ResponseEntity<ResultData<List<WishlistOrderCMSResponse>>> getAllUser() {
	var response = wishlistOrderService.getAllWishlistOrder();
	return new ResponseEntity<ResultData<List<WishlistOrderCMSResponse>>>(response, HttpStatus.OK);
    }
}
