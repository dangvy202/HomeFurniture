package com.furniture.hms.service.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.entity.Blog;
import com.furniture.hms.mapper.blog.BlogMapper;
import com.furniture.hms.repository.blog.BlogRepository;
import com.furniture.hms.service.comment.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final CommentService commentService;

    public List<BlogResponse> getAllBlog() {
	List<Blog> arrBlog = blogRepository.findAll();
	List<BlogResponse> responses = new ArrayList<>();
	if (!arrBlog.isEmpty()) {
	    for (Blog blog : arrBlog) {
		if (blog.getStatus() != 0) {
		    responses.add(BlogMapper.INSTANCE.toBlogResponse(blog));
		}
	    }
	    return responses;
	} else {
	    return null;
	}
    }

    public List<BlogResponse> getBlogByCategoryBlogId(int id) {
	List<Blog> arrBlog = blogRepository.findBlogByIdCategoryBlog(id);
	List<BlogResponse> responses = new ArrayList<>();

	if (!arrBlog.isEmpty()) {
	    for (Blog blog : arrBlog) {
		if (blog.getStatus() != 0) {
		    BlogResponse blogRes = BlogMapper.INSTANCE.toBlogResponse(blog);
		    blogRes.setCommentBlog(commentService.getCommentByIdBlog(blog.getId()));
		    responses.add(blogRes);
		}
	    }
	    return responses;
	} else {
	    return null;
	}
    }

    public BlogResponse getBlogDetailById(int id) {
	BlogResponse response = new BlogResponse();
	Blog blog = blogRepository.findById(id).orElse(null);
	if (blog != null && blog.getStatus() != 0) {
	    response = BlogMapper.INSTANCE.toBlogResponse(blog);
	    response.setCommentBlog(commentService.getCommentByIdBlog(blog.getId()));
	    return response;
	} else {
	    return null;
	}
    }
}
