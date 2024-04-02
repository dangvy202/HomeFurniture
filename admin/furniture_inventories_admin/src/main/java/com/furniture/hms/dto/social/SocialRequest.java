package com.furniture.hms.dto.social;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SocialRequest {
    private String facebook;
    private String twiter;
    private String tiktok;
    private String instagram;
}
