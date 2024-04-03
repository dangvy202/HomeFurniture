package com.furniture.hms.service.banner;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;

import com.furniture.hms.constant.BannerMessage;
import com.furniture.hms.dto.banner.BannerRequest;
import com.furniture.hms.dto.banner.BannerResponse;
import com.furniture.hms.dto.result_data.ResultData;
import com.furniture.hms.entity.Banner;
import com.furniture.hms.mapper.banner.BannerMapper;
import com.furniture.hms.repository.banner.BannerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;

    private static final String PATH_SRC_FRONTEND = "D:\\furniture\\new pull for blog\\HomeFurniture\\frontend\\furniture_home\\src\\component\\asset\\home";

    private String saveImageInToFolder(String path, String image, byte[] imageByte) {
	// save image into folder
	try {
	    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(path, image)));
	    outputStream.write(imageByte);
	    outputStream.flush();
	    outputStream.close();
	    // end save image into folder
	    return BannerMessage.BANNER_SUCCESS;
	} catch (Exception ex) {
	    return BannerMessage.BANNER_FAIL;
	}
    }

    @Transactional
    public ResultData<BannerResponse> updateBanner(BannerRequest request) {

	BannerResponse response = new BannerResponse();

	Banner banner = bannerRepository.findById(request.getId()).orElse(null);

	if (banner != null) {
	    try {
		if (request.getImage().getOriginalFilename() != null || !request.getImage().isEmpty()
			|| request.getImage().getContentType().equals("image/jpeg")
			|| request.getImage().getContentType().equals("image/png")) {

		    // declare file
		    String oldFileName = banner.getBannerUrl();
		    String renameFile = request.getImage().getOriginalFilename();
		    // rename to push
		    if (request.getImage().getContentType().equals("image/jpeg")) {
			renameFile = UUID.randomUUID().toString() + ".jpg";
		    } else {
			renameFile = UUID.randomUUID().toString() + ".png";
		    }

		    // edit banner in DB
		    banner.setBannerUrl(renameFile);
		    banner.setUpdateDate(new Date());

		    bannerRepository.save(banner);

		    // save new picture
		    String noticeSavePicture = this.saveImageInToFolder(PATH_SRC_FRONTEND, renameFile,
			    request.getImage().getBytes());
		    if (noticeSavePicture.equals(BannerMessage.BANNER_FAIL)) {
			throw new ApplicationContextException(BannerMessage.BANNER_INSERT_FAIL);
		    }

		    // delete old img
		    File tempFile = new File(PATH_SRC_FRONTEND + "\\" + oldFileName);
		    Boolean deleteCheck = tempFile.delete();

		    if (deleteCheck != Boolean.TRUE) {
			throw new ApplicationContextException(BannerMessage.BANNER_DELETE_FAIL);
		    }

		    response = BannerMapper.INSTANCE.toBannerRes(banner);
		    return new ResultData<BannerResponse>(Boolean.TRUE, null, noticeSavePicture, response);
		}

	    } catch (Exception e) {
		return new ResultData<BannerResponse>(Boolean.FALSE, BannerMessage.BANNER_FAIL,
			BannerMessage.BANNER_FAIL, response);
	    }
	}
	return new ResultData<BannerResponse>(Boolean.FALSE, BannerMessage.BANNER_NOT_EXIST,
		BannerMessage.BANNER_NOT_EXIST, response);
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
