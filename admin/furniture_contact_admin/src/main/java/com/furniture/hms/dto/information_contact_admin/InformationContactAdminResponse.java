package com.furniture.hms.dto.information_contact_admin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@Getter
@Setter
public class InformationContactAdminResponse {

    private String email;

    private String address;

    private String hotline;

    private String createBy;

    private Instant createDate;

    private String updateBy;

    private Instant updateDate;
}
