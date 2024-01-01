package com.furniture.hms.dto.category;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Integer id;
    private String categoryName;
    private String categoryPicture;
    private String categoryRedirect;
}
