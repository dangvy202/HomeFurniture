package com.furniture.hms.feign.information;

import java.util.List;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.furniture.hms.dto.result.ResultData;
import com.furniture.hms.dto.wishlist.WishlistOrderCMSResponse;

import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "furnitureInfomationsAdmin", contextId = "WishlistCMSFeign", fallbackFactory = WishlistCMSFeign.WishlistCMSFeignFallBack.class)
public interface WishlistCMSFeign {

    @GetMapping("/wishlist")
    ResultData<List<WishlistOrderCMSResponse>> getAllWishlist();

    @Component
    @Slf4j
    class WishlistCMSFeignFallBack implements FallbackFactory<WishlistCMSFeign> {

	@Override
	public WishlistCMSFeign create(Throwable cause) {
	    return null;
	}
    }
}
