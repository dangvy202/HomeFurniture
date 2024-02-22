package com.furniture.hms.service.wishlist;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.furniture.hms.constant.WishlistOrderMessage;
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

    public WishlistOrderResponse addWishlistOrder(WishlistOrderRequest request) {

	WishlistOrderResponse response = new WishlistOrderResponse();

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
		response.setStatus(Boolean.TRUE);
		response.setError(null);
		response.setMessage(WishlistOrderMessage.SUCCESS);
		return response;

	    } else {
		// edit quantity old wishlist
		wishlistOrderExist.setWishlistQuantity(wishlistOrderExist.getWishlistQuantity() + 1);
		wishlistRepository.save(wishlistOrderExist);
		response.setStatus(Boolean.TRUE);
		response.setError(null);
		response.setMessage(WishlistOrderMessage.SUCCESS);
		return response;
	    }

	} else {
	    response.setStatus(Boolean.FALSE);
	    response.setError(WishlistOrderMessage.NOT_FOUND);
	    response.setMessage(WishlistOrderMessage.FAIL);
	    return response;
	}
    }

}
