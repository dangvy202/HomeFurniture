package com.furniture.hms.dto.social;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SocialResponse {
    private String facebook;
    private String twiter;
    private String tiktok;
    private String instagram;
}
