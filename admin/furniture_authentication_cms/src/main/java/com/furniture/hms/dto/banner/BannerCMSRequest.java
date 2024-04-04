package com.furniture.hms.dto.banner;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class BannerCMSRequest {

    private int id;

    private MultipartFile image;

}
