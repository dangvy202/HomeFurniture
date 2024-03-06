package com.furniture.hms.service.banner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.entity.Banner;
import com.furniture.hms.mapper.banner.BannerMapper;
import com.furniture.hms.repository.banner.BannerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;

    @Transactional
    public List<BannerResponse> getAllBanner() {
	List<BannerResponse> response = new ArrayList<>();

	List<Banner> bannerList = bannerRepository.findAll();
	if (!CollectionUtils.isEmpty(bannerList)) {
	    bannerList.forEach(banner -> {
		BannerResponse bannerResponse = BannerMapper.INSTANCE.toBannerRes(banner);
		response.add(bannerResponse);
	    });
	}

	return response;
    }

}
