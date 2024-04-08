package com.furniture.hms.dto.contact_description;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class ContactDescriptionResponse {
    private int id_description;
    private String title;
    private String description;
    private Date createDate;
}
