package com.furniture.hms.service.blog;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.entity.Blog;
import com.furniture.hms.mapper.blog.BlogMapper;
import com.furniture.hms.repository.blog.BlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<BlogResponse> getBlogById(int id) {
        List<Blog> arrBlog = blogRepository.findBlogByIdCategoryBlog(id);
        List<BlogResponse> responses = new ArrayList<>();
        if(!arrBlog.isEmpty()){
            for(Blog blog : arrBlog) {
                if(blog.getStatus() != 0) {
                    responses.add(BlogMapper.INSTANCE.toBlogResponse(blog));
                }
            }
            return responses;
        } else {
            return null;
        }
    }
}
