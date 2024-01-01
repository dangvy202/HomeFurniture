package com.furniture.hms.mapper.tagblog;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.tagblog.TagBlogResponse;
import com.furniture.hms.entity.TagBlog;

@Mapper(componentModel = "spring")
public interface TagBlogMapper {

    TagBlogMapper INSTANCE = Mappers.getMapper(TagBlogMapper.class);

    TagBlogResponse toTagBlogResponse(TagBlog tagBlog);
}
