package com.furniture.hms.service.category;

import java.util.ArrayList;
import java.util.List;

import com.furniture.hms.dto.blog.BlogResponse;
import org.springframework.stereotype.Service;

import com.furniture.hms.dto.category.CategoryBlogResponse;
import com.furniture.hms.entity.CategoryBlog;
import com.furniture.hms.mapper.category.CategoryBlogMapper;
import com.furniture.hms.repository.category.CategoryBlogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryBlogService {

    private final CategoryBlogRepository categoryBlogRepository;

    public List<CategoryBlogResponse> getAllCategoriesBlog() {
		List<CategoryBlog> arrCategory = categoryBlogRepository.findAll();
		List<CategoryBlogResponse> arrResponse = new ArrayList<>();
		if (!arrCategory.isEmpty()) {
			for (CategoryBlog categoryBlogDetail : arrCategory) {
				if (categoryBlogDetail.getStatus() != 0) {
					arrResponse.add(CategoryBlogMapper.INSTANCE.toCategoryResponse(categoryBlogDetail));
				}
			}
			return arrResponse;
		} else {
			return null;
		}
    }

	public List<BlogResponse> getAllBlogById(int id) {
		return null;
	}
}
