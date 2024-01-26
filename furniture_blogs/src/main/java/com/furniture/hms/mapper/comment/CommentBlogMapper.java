package com.furniture.hms.mapper.comment;

import java.time.Instant;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.furniture.hms.dto.comment.CommentResponse;

@Mapper(componentModel = "spring")
public interface CommentBlogMapper {
    CommentBlogMapper INSTANCE = Mappers.getMapper(CommentBlogMapper.class);

    @Mapping(target = "content", source = "content")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "updateDate", source = "updateDate")
    CommentResponse.CommentDetail toCommentResponse(String content, int status, Instant updateDate);

    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "picture", source = "picture")
    CommentResponse.CommentDetail.UserInforDetail toCommentUserInforDetail(String userName, String picture);

}
