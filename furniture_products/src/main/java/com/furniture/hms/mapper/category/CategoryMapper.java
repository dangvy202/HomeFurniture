package com.furniture.hms.mapper.category;

import com.furniture.hms.dto.category.CategoryResponse;
import com.furniture.hms.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponse toCategoryResponse(Category category);
}
