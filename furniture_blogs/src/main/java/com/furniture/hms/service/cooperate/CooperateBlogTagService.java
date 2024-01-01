package com.furniture.hms.service.cooperate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.dto.cooperate.CooperateResponse;
import com.furniture.hms.dto.tagblog.TagBlogResponse;
import com.furniture.hms.entity.CooperateBlogTag;
import com.furniture.hms.mapper.blog.BlogMapper;
import com.furniture.hms.mapper.tagblog.TagBlogMapper;
import com.furniture.hms.repository.cooperate.CooperateBlogTagRepository;
import com.furniture.hms.service.comment.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CooperateBlogTagService {

    private final CooperateBlogTagRepository cooperateBlogTagRepository;
    private final CommentService commentService;

    public CooperateResponse getListBlogByTagBlog(int id) {
	List<CooperateBlogTag> arrCooperateBlogTag = cooperateBlogTagRepository.findCooperateBlogTagByTagBlog(id);

	CooperateResponse response = new CooperateResponse();

	CooperateResponse.BlogDetail blogDetailCooperate = new CooperateResponse.BlogDetail();

	// declared response
	List<BlogResponse> blogResponse = new ArrayList<>();
	TagBlogResponse tagBlogResponse = new TagBlogResponse();
	if (!arrCooperateBlogTag.isEmpty()) {
	    for (CooperateBlogTag cooperateBlogTagDetail : arrCooperateBlogTag) {
		if (cooperateBlogTagDetail.getBlog().getStatus() != 0) {
		    BlogResponse res = BlogMapper.INSTANCE.toBlogResponse(cooperateBlogTagDetail.getBlog());
		    res.setCommentBlog(commentService.getCommentByIdBlog(cooperateBlogTagDetail.getId()));

		    blogResponse.add(res);
		    tagBlogResponse = TagBlogMapper.INSTANCE.toTagBlogResponse(cooperateBlogTagDetail.getTagBlog());
		}
	    }
	    blogDetailCooperate.setBlogResponse(blogResponse);
	    blogDetailCooperate.setTagBlogResponse(tagBlogResponse);
	    response.setBlog(blogDetailCooperate);
	    return response;
	} else {
	    return null;
	}
    }

}
