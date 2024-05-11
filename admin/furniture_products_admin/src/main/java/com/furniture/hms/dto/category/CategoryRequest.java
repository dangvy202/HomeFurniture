package com.furniture.hms.dto.category;

import com.furniture.hms.enums.StatusEnum;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    private String categoryName;
    private String categoryRedirect;
    private String categoryPicture;
    private StatusEnum status;
}
