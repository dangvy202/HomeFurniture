package com.furniture.hms.dto.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.hms.enums.StatusEnum;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
    @JsonProperty("categoryName")
    private String categoryName;
    @JsonProperty("categoryRedirect")
    private String categoryRedirect;
    @JsonProperty("status")
    private StatusEnum status;
    @JsonProperty("file")
    private MultipartFile file;
}
