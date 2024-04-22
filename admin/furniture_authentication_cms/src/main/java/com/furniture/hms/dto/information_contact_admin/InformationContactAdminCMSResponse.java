package com.furniture.hms.dto.information_contact_admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Data
@Getter
@Setter
public class InformationContactAdminCMSResponse {

    private String email;

    private String address;

    private String hotline;

    private String createBy;

    private Instant createDate;

    private String updateBy;

    private Instant updateDate;
}
