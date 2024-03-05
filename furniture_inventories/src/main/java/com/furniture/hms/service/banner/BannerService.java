package com.furniture.hms.service.banner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.entity.Banner;
import com.furniture.hms.entity.ProductSpecial;
import com.furniture.hms.feign.ProductFeign;
import com.furniture.hms.mapper.productSpecial.ProductSpecialMapper;
import com.furniture.hms.repository.banner.BannerRepository;
import com.furniture.hms.repository.productSpecial.ProductSpecialRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;
    private final ProductSpecialRepository productSpecialRepository;
    private final ProductFeign productFeign;

    @Transactional
    public List<BannerResponse> getAllBannerAndSpecialProduct() {
	List<BannerResponse> response = new ArrayList<>();

	List<Banner> bannerList = bannerRepository.findAll();

	if (!CollectionUtils.isEmpty(bannerList)) {
	    bannerList.forEach(banner -> {
		List<ProductSpecial> productSpecialList = productSpecialRepository.findProductSpecialByBanner(banner);
		List<BannerResponse.ProductResponse> listProductSpecial = new ArrayList<>();

		if (!CollectionUtils.isEmpty(productSpecialList)) {
		    productSpecialList.forEach(productSpecial -> {
			BannerResponse.ProductResponse productResponse = new BannerResponse.ProductResponse();
			var productFeignRes = productFeign.getDetailByIdProduct(productSpecial.getProductId());
			productResponse = ProductSpecialMapper.INSTANCE.toProductBannerRes(productFeignRes);
			listProductSpecial.add(productResponse);

		    });
		    BannerResponse bannerResponse = new BannerResponse();
		    bannerResponse.setBannerName(banner.getBannerName());
		    bannerResponse.setBannerUrl(banner.getBannerUrl());
		    bannerResponse.setProduct(listProductSpecial);
		    response.add(bannerResponse);
		}
	    });

	    return response;
	}
	return response;
    }
}
