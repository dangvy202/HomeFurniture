package com.furniture.hms.service.information;

import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderCMSResponse;
import com.furniture.hms.feign.information.WishlistCMSFeign;
import com.furniture.hms.service.spi.information.WishlistOrderServiceSpi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WishlistOrderService implements WishlistOrderServiceSpi {

    private final WishlistCMSFeign wishlistCMSFeign;

    @Override
    public ResultData<List<WishlistOrderCMSResponse>> getAllWishlistOrder() {
	ResultData<List<WishlistOrderCMSResponse>> response = wishlistCMSFeign.getAllWishlist();
	return response;
    }
}
