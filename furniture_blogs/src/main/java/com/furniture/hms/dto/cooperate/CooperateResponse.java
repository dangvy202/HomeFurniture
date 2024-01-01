package com.furniture.hms.dto.cooperate;

import java.util.List;

import com.furniture.hms.dto.blog.BlogResponse;
import com.furniture.hms.dto.tagblog.TagBlogResponse;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CooperateResponse {

    BlogDetail blog;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class BlogDetail {
	private List<BlogResponse> blogResponse;
	private TagBlogResponse tagBlogResponse;
    }
}