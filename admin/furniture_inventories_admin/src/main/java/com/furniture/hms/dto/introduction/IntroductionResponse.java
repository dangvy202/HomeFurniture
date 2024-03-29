package com.furniture.hms.dto.introduction;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class IntroductionResponse {

    private String description;

    private String name;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;
}
