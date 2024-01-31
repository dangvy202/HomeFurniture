package com.furniture.hms.service.comment;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.constant.CommentMessage;
import com.furniture.hms.dto.comment.CommentRequest;
import com.furniture.hms.dto.comment.CommentResponse;
import com.furniture.hms.dto.comment.CommentResponse.CommentDetail;
import com.furniture.hms.entity.Blog;
import com.furniture.hms.entity.Comment;
import com.furniture.hms.feign.UserFeign;
import com.furniture.hms.feign.interceptor.TokenProvider;
import com.furniture.hms.feign.response.UserResponse.UserResponse;
import com.furniture.hms.mapper.comment.CommentBlogMapper;
import com.furniture.hms.repository.blog.BlogRepository;
import com.furniture.hms.repository.comment.CommentBlogRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentBlogRepository commentBlogRepository;

    private final UserFeign userFeign;

    private final TokenProvider tokenProvider;

    private final BlogRepository blogRepository;

    @Transactional
    public CommentResponse saveCommmentBlog(CommentRequest request) {

	CommentResponse response = new CommentResponse();

	try {

	    tokenProvider.setToken(request.getToken());
	    UserResponse userResponse = userFeign.infomationAccount(request.getEmail());

	    if (!request.getToken().isEmpty() && !request.getEmail().isEmpty()) {
		// set token

		Blog blog = blogRepository.findById(request.getIdBlog()).orElse(null);

		if (blog != null) {
		    Instant dateNow = Instant.now();
		    Comment comment = new Comment();
		    comment = CommentBlogMapper.INSTANCE.toCommentEntity(request.getContent(), 1,
			    userResponse.getUser().getUserName(), userResponse.getUser().getPicture(), blog,
			    userResponse.getUser().getUserName(), dateNow, userResponse.getUser().getUserName(),
			    dateNow);

		    commentBlogRepository.save(comment);

		    // set attribute
		    response.setError(null);
		    response.setMessage(CommentMessage.COMMENT_SUCCESS);
		    response.setStatus(true);
		    return response;
		} else {
		    response.setError(CommentMessage.COMMENT_FAIL);
		    response.setMessage(CommentMessage.COMMENT_BLOG);
		    response.setStatus(false);
		    return response;
		}
	    } else {
		response.setError(CommentMessage.COMMENT_FAIL);
		response.setMessage(CommentMessage.COMMENT_MISSING);
		response.setStatus(false);
		return response;
	    }
	} catch (Exception e) {
	    log.debug(e.getMessage());
	    response.setError(CommentMessage.COMMENT_FAIL);
	    response.setMessage(CommentMessage.COMMENT_USER);
	    response.setStatus(false);
	    return response;
	}
    }

    public CommentResponse getCommentByIdBlog(int id) {
	int count = commentBlogRepository.countByIdBlog(id);

	List<Comment> arrComment = commentBlogRepository.findCommentByIdBlog(id);

	CommentResponse response = new CommentResponse();
	List<CommentResponse.CommentDetail> arrCommentDetail = new ArrayList<>();
	if (!arrComment.isEmpty()) {
	    for (Comment comment : arrComment) {
		if (comment.getStatus() != 0) {
		    CommentResponse.CommentDetail commentDetail = new CommentDetail();
		    commentDetail = CommentBlogMapper.INSTANCE.toCommentResponse(comment.getContent(),
			    comment.getStatus(), comment.getUpdateDate());
		    commentDetail.setUser(CommentBlogMapper.INSTANCE.toCommentUserInforDetail(comment.getUserName(),
			    comment.getPicture()));
		    arrCommentDetail.add(commentDetail);
		}
	    }
	    response.setTotal(count);
	    response.setComment(arrCommentDetail);
	    return response;
	} else {
	    response.setTotal(count);
	    response.setComment(arrCommentDetail);
	    return response;
	}
    }
}
