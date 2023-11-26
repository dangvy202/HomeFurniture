package com.furniture.hms.mapper.category;

import com.furniture.hms.dto.category.CategoryBlogResponse;
import com.furniture.hms.entity.CategoryBlog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryBlogMapper {
    CategoryBlogMapper INSTANCE = Mappers.getMapper(CategoryBlogMapper.class);

    CategoryBlogResponse toCategoryResponse(CategoryBlog categoryBlog);
}
