package com.furniture.hms.service.wishlist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.constant.WishlistOrderMessage;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderResponse;
import com.furniture.hms.entity.WishlistOrder;
import com.furniture.hms.feign.ProductFeign;
import com.furniture.hms.feign.response.ProductResponse.ProductResponse;
import com.furniture.hms.mapper.wishlist.WishlistOrderMapper;
import com.furniture.hms.repository.user.UserRepository;
import com.furniture.hms.repository.wishlist.WishlistOrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WishlistOrderService {

    private final UserRepository userRepository;

    private final ProductFeign productFeign;

    private final WishlistOrderRepository wishlistRepository;

    public ResultData<List<WishlistOrderResponse>> getAllWishlistOrder() {
	List<WishlistOrderResponse> response = new ArrayList<>();

	List<WishlistOrder> wishlistArr = wishlistRepository.findAll();

	if (!CollectionUtils.isEmpty(wishlistArr)) {
	    wishlistArr.forEach(wishlist -> {
		WishlistOrderResponse.User wishListUserResponse = new WishlistOrderResponse.User();
		WishlistOrderResponse.Product wishlistProduct = new WishlistOrderResponse.Product();
		WishlistOrderResponse wishlistOrderResponse = new WishlistOrderResponse();

		ProductResponse product = productFeign.getDetailByIdProduct(wishlist.getIdProduct());

		wishListUserResponse.setEmail(wishlist.getUser().getEmail());
		wishlistProduct = WishlistOrderMapper.INSTANCE.toWishlistProductOrderResponse(wishlist.getTotalPrice(),
			product.getId(), product.getProductName(), product.getProductPrice(),
			product.getProductSaleoff(), wishlist.getWishlistQuantity());
		wishlistProduct.setPicture(WishlistOrderMapper.INSTANCE
			.toWishlistPictureOrderResponse(product.getPicture().getPictureFirst()));

		wishlistOrderResponse.setUser(wishListUserResponse);
		wishlistOrderResponse.setProduct(wishlistProduct);
		response.add(wishlistOrderResponse);
	    });
	    return new ResultData<List<WishlistOrderResponse>>(Boolean.TRUE, null, WishlistOrderMessage.SUCCESS,
		    response);
	} else {
	    return new ResultData<List<WishlistOrderResponse>>(Boolean.TRUE, null, WishlistOrderMessage.EMPTY,
		    response);
	}
    }

}
