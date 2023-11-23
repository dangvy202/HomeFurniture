package com.furniture.hms.service.category;

import com.furniture.hms.dto.category.CategoryBlogResponse;
import com.furniture.hms.entity.CategoryBlog;
import com.furniture.hms.repository.CategoryBlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryBlogService {

    private final CategoryBlogRepository categoryBlogRepository;

    public List<CategoryBlogResponse> getAllCategoryBlog() {
        List<CategoryBlog> arrCategory = categoryBlogRepository.findAll();

        if(!arrCategory.isEmpty()) {

        }else {
            return null;
        }
    }
}
