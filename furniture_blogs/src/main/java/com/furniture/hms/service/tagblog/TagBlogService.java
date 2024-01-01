package com.furniture.hms.service.tagblog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.tagblog.TagBlogResponse;
import com.furniture.hms.entity.TagBlog;
import com.furniture.hms.mapper.tagblog.TagBlogMapper;
import com.furniture.hms.repository.tagblog.TagBlogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TagBlogService {

    private final TagBlogRepository tagBlogRepository;

    public List<TagBlogResponse> getAllTagBlog() {
	List<TagBlog> arrTagBlog = tagBlogRepository.findAll();

	List<TagBlogResponse> response = new ArrayList<>();

	if (!arrTagBlog.isEmpty()) {
	    for (TagBlog tagBlogDetail : arrTagBlog) {
		if (tagBlogDetail.getStatus() != 0) {
		    response.add(TagBlogMapper.INSTANCE.toTagBlogResponse(tagBlogDetail));
		}
	    }
	    return response;
	} else {
	    return null;
	}
    }
}
