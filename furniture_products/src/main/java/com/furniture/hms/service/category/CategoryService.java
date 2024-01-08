package com.furniture.hms.service.category;

import com.furniture.hms.dto.category.CategoryResponse;
import com.furniture.hms.entity.Category;
import com.furniture.hms.mapper.category.CategoryMapper;
import com.furniture.hms.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getAllCategories() {
        List<Category> listCategories = categoryRepository.findAll();

        List<CategoryResponse> listCategoriesResponse = new ArrayList<>();

        if(!listCategories.isEmpty()) {
            for (Category category : listCategories){
                if(category.getStatus() == 1) {
                    CategoryResponse detailResponse = CategoryMapper.INSTANCE.toCategoryResponse(category);
                    listCategoriesResponse.add(detailResponse);
                }
            }
            return listCategoriesResponse;
        }else {
            return null;
        }
    }

}
