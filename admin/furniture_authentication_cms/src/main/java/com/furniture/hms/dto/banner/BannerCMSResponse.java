package com.furniture.hms.dto.banner;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class BannerCMSResponse {

    private String bannerName;

    private String bannerUrl;

}
