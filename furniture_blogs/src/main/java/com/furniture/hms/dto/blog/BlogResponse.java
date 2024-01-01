package com.furniture.hms.dto.blog;

import java.util.Date;

import com.furniture.hms.dto.category.CategoryBlogResponse;
import com.furniture.hms.dto.comment.CommentResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponse {

    private Integer id;
    private String blogTitle;
    private Integer status;
    private String content;
    private String shortContent;
    private String blogAvatar;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private CategoryBlogResponse categoryBlog;
    private CommentResponse commentBlog;
}
