package com.furniture.hms.mapper.comment;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.comment.CommentResponse;
import com.furniture.hms.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentBlogMapper {
    CommentBlogMapper INSTANCE = Mappers.getMapper(CommentBlogMapper.class);

    CommentResponse.CommentDetail toCommentResponse(Comment comment);

}
