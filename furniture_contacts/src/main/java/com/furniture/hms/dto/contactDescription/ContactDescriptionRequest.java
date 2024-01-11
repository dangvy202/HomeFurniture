package com.furniture.hms.dto.contactDescription;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ContactDescriptionRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;
}
