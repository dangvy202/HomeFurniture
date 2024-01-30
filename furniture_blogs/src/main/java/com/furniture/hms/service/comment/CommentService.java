package com.furniture.hms.service.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.comment.CommentRequest;
import com.furniture.hms.dto.comment.CommentResponse;
import com.furniture.hms.dto.comment.CommentResponse.CommentDetail;
import com.furniture.hms.entity.Comment;
import com.furniture.hms.feign.UserFeign;
import com.furniture.hms.mapper.comment.CommentBlogMapper;
import com.furniture.hms.repository.comment.CommentBlogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentBlogRepository commentBlogRepository;

    private final UserFeign userFeign;

    private final com.furniture.hms.feign.interceptor.TokenProvider tokenProvider;

    public CommentResponse saveCommmentBlog(CommentRequest request) {
	tokenProvider.setToken(request.getToken());
	var a = userFeign.infomationAccount("Vy.Tran@nttdata.com");
	System.out.println("check it ne = " + a);
	return null;
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
