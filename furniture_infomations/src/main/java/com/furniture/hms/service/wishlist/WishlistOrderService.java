package com.furniture.hms.service.wishlist;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.constant.WishlistOrderMessage;
import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderRequest;
import com.furniture.hms.dto.wishlist.WishlistOrderResponse;
import com.furniture.hms.entity.User;
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

    public ResultData getAllWishlistOrderByEmail(String email) {
	WishlistOrderResponse response = new WishlistOrderResponse();

	User user = userRepository.findUserByEmail(email).orElse(null);
	WishlistOrderResponse.User userRes = new WishlistOrderResponse.User();
	ResultData result = new ResultData();

	if (user != null) {
	    List<WishlistOrder> arrWishlistOrder = wishlistRepository.findWishlistOrderByUser(user);
	    List<WishlistOrderResponse.Product> arrProduct = new ArrayList<>();
	    if (arrWishlistOrder.size() > 0) {
		arrWishlistOrder.stream().forEach(wishlistOrder -> {
		    WishlistOrderResponse.Product wishlistProduct = new WishlistOrderResponse.Product();

		    ProductResponse product = productFeign.getDetailByIdProduct(wishlistOrder.getIdProduct());

		    wishlistProduct = WishlistOrderMapper.INSTANCE.toWishlistProductOrderResponse(
			    product.getProductName(), product.getProductPrice(), product.getProductSaleoff(),
			    wishlistOrder.getWishlistQuantity());
		    wishlistProduct.setPicture(WishlistOrderMapper.INSTANCE
			    .toWishlistPictureOrderResponse(product.getPicture().getPictureFirst()));
		    arrProduct.add(wishlistProduct);
		});
		userRes.setEmail(user.getEmail());
		response.setUser(userRes);
		response.setProduct(arrProduct);
		result.setError(null);
		result.setMessage(WishlistOrderMessage.SUCCESS);
		result.setStatus(Boolean.TRUE);
		result.setResultData(response);
		return result;
	    } else {
		result.setError(null);
		result.setMessage(WishlistOrderMessage.EMPTY);
		result.setStatus(Boolean.TRUE);
		result.setResultData(response);
		return result;
	    }
	} else {
	    result.setError(WishlistOrderMessage.FAIL);
	    result.setMessage(WishlistOrderMessage.NOT_FOUND);
	    result.setStatus(Boolean.FALSE);
	    result.setResultData(response);
	    return result;
	}
    }

    public ResultData addWishlistOrder(WishlistOrderRequest request) {

	ResultData resultData = new ResultData();

	User user = userRepository.findUserByEmail(request.getEmail()).orElse(null);
	ProductResponse product = productFeign.getDetailByIdProduct(request.getIdProduct());

	if (user != null) {
	    WishlistOrder wishlistOrderExist = wishlistRepository
		    .findWishlistOrderByUserAndIdProduct(user, product.getId()).orElse(null);

	    if (wishlistOrderExist == null) {
		// add new wishlist
		WishlistOrder wishlistOrder = WishlistOrderMapper.INSTANCE.toWishlistOrderEntity(request.getIdProduct(),
			1, user, user.getUserName(), Instant.now(), user.getUserName(), Instant.now());

		wishlistRepository.save(wishlistOrder);
		resultData.setStatus(Boolean.TRUE);
		resultData.setError(null);
		resultData.setMessage(WishlistOrderMessage.SUCCESS);
		return resultData;

	    } else {
		// edit quantity old wishlist
		wishlistOrderExist.setWishlistQuantity(wishlistOrderExist.getWishlistQuantity() + 1);
		wishlistRepository.save(wishlistOrderExist);
		resultData.setStatus(Boolean.TRUE);
		resultData.setError(null);
		resultData.setMessage(WishlistOrderMessage.SUCCESS);
		return resultData;
	    }

	} else {
	    resultData.setStatus(Boolean.FALSE);
	    resultData.setError(WishlistOrderMessage.NOT_FOUND);
	    resultData.setMessage(WishlistOrderMessage.FAIL);
	    return resultData;
	}
    }

}
