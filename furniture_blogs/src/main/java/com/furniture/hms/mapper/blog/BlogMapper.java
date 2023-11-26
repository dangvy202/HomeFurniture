package com.furniture.hms.mapper.blog;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.entity.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);

    BlogResponse toBlogResponse(Blog blog);
}
