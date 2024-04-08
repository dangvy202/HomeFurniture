package com.furniture.hms.dto.contact_description;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ContactDescriptionRequest {

    @JsonProperty("id_description")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

}
