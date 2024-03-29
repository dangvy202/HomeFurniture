package com.furniture.hms.service.introduction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.furniture.hms.dto.introduction.IntroductionResponse;
import com.furniture.hms.entity.Introduction;
import com.furniture.hms.mapper.introduction.IntroductionMapper;
import com.furniture.hms.repository.introduction.IntroductionRepository;

@Service
public class IntroductionService {

    @Autowired
    private IntroductionRepository introductionRepository;

    public List<IntroductionResponse> getIntroduction() {
	List<IntroductionResponse> response = new ArrayList<>();

	List<Introduction> introductionList = introductionRepository.findAll();

	if (!CollectionUtils.isEmpty(introductionList)) {
	    introductionList.forEach(introduction -> {
		IntroductionResponse responseMapper = IntroductionMapper.INSTANCE.toIntroductionRes(introduction);
		response.add(responseMapper);
	    });
	}
	return response;
    }
}
