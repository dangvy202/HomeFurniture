package com.furniture.hms.mapper.category;

import com.furniture.hms.dto.category.CategoryRequest;
import com.furniture.hms.dto.category.CategoryResponse;
import com.furniture.hms.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponse toCategoryResponse(Category category);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categoryName", source = "categoryName")
    @Mapping(target = "categoryPicture", source = "categoryPicture")
    @Mapping(target = "categoryRedirect", source = "categoryRedirect")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateDate", source = "updateDate")
    Category toCategoryEntity(String categoryName, String categoryPicture, String categoryRedirect, int status, String createBy, Instant createDate, String updateBy, Instant updateDate);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categoryName", source = "categoryName")
    @Mapping(target = "categoryRedirect", source = "categoryRedirect")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "createDate", source = "createDate")
    @Mapping(target = "updateBy", source = "updateBy")
    @Mapping(target = "updateDate", source = "updateDate")
    Category toCategoryEntityNotImage(String categoryName, String categoryRedirect, int status, String createBy, Instant createDate, String updateBy, Instant updateDate);

}
