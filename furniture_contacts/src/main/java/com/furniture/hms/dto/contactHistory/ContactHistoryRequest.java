package com.furniture.hms.dto.contactHistory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.furniture.hms.dto.contactDescription.ContactDescriptionRequest;
import com.furniture.hms.dto.informationContactClient.InformationContactClientRequest;
import com.furniture.hms.entity.InformationContactClient;
import com.furniture.hms.enums.ProcessEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.time.Instant;

@Data
@Getter
@Setter
public class ContactHistoryRequest {

    @JsonProperty("process")
    private ProcessEnum process;

    @JsonProperty("message")
    private String message;

    @JsonProperty("contactDescription")
    private ContactDescriptionDetail contactDescriptionDetail;

    @JsonProperty("informationContactClient")
    private InformationContactClientDetail informationContactClientDetail;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ContactDescriptionDetail {

        @JsonProperty("contactDescriptionRequest")
        private ContactDescriptionRequest contactDescriptionRequest;
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class InformationContactClientDetail {


        @JsonProperty("informationContactClientRequest")
        private InformationContactClientRequest informationContactClientRequest;
    }
}
