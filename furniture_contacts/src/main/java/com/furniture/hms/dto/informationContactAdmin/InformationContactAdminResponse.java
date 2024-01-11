package com.furniture.hms.dto.informationContactAdmin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.hms.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@Getter
@Setter
public class InformationContactAdminResponse {
    private List<InformationContactAdminDetail> informationContactAdminDetailList;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class InformationContactAdminDetail {
        @JsonProperty("email")
        private String email;

        @JsonProperty("address")
        private String address;

        @JsonProperty("hotline")
        private String hotline;

        @JsonProperty("create_by")
        private String createBy;

        @JsonProperty("create_date")
        private Instant createDate;

        @JsonProperty("update_by")
        private String updateBy;

        @JsonProperty("update_date")
        private Instant updateDate;

    }
}
