package com.furniture.hms.service.blog;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.entity.Blog;
import com.furniture.hms.mapper.blog.BlogMapper;
import com.furniture.hms.repository.blog.BlogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

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
		    responses.add(BlogMapper.INSTANCE.toBlogResponse(blog));
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
	    return response;
	} else {
	    return null;
	}
    }
}
