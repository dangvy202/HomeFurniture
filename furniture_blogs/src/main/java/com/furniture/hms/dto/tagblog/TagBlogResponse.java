package com.furniture.hms.dto.tagblog;

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
public class TagBlogResponse {

    private Integer id;
    private String tagName;
    private Integer status;
}
