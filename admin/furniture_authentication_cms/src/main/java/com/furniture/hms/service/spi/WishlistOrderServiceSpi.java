package com.furniture.hms.service.spi;

import java.util.List;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderCMSResponse;

@Component
public interface WishlistOrderServiceSpi {

    ResultData<List<WishlistOrderCMSResponse>> getAllWishlistOrder();
}
