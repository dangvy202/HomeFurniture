package com.furniture.hms.service.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.comment.CommentResponse;
import com.furniture.hms.entity.Comment;
import com.furniture.hms.mapper.comment.CommentBlogMapper;
import com.furniture.hms.repository.comment.CommentBlogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentBlogRepository commentBlogRepository;

    public CommentResponse getCommentByIdBlog(int id) {
	int count = commentBlogRepository.countByIdBlog(id);

	List<Comment> arrComment = commentBlogRepository.findCommentByIdBlog(id);

	CommentResponse response = new CommentResponse();
	List<CommentResponse.CommentDetail> commentDetail = new ArrayList<>();
	if (!arrComment.isEmpty()) {
	    for (Comment comment : arrComment) {
		if (comment.getStatus() != 0) {
		    commentDetail.add(CommentBlogMapper.INSTANCE.toCommentResponse(comment));
		}
	    }
	    response.setTotal(count);
	    response.setComment(commentDetail);
	    return response;
	} else {
	    response.setTotal(count);
	    response.setComment(commentDetail);
	    return response;
	}
    }
}
