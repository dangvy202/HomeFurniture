package com.furniture.hms.service.banner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.Banner;
import com.furniture.hms.repository.banner.BannerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;

    private static final String PATH_SRC_FRONTEND = "";

    @Transactional
    public ResultData<BannerResponse> updateBanner(MultipartFile image, int id) {
	Banner banner = bannerRepository.findById(id).orElse(null);

	if (banner != null) {
	    try {

		BufferedOutputStream outputStream = new BufferedOutputStream(
			new FileOutputStream(new File(PATH_SRC_FRONTEND, image.getOriginalFilename())));
	    } catch (Exception e) {
		// TODO: handle exception
	    }
	}
	return null;
    }

//    @Transactional
//    public List<BannerResponse> getAllBanner() {
//	List<BannerResponse> response = new ArrayList<>();
//
//	List<Banner> bannerList = bannerRepository.findAll();
//	if (!CollectionUtils.isEmpty(bannerList)) {
//	    bannerList.forEach(banner -> {
//		BannerResponse bannerResponse = BannerMapper.INSTANCE.toBannerRes(banner);
//		response.add(bannerResponse);
//	    });
//	}
//
//	return response;
//    }

}
