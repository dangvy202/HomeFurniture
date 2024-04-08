package com.furniture.hms.dto.contact_history;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Data
@Setter
@Getter
public class ContactHistoryResponse {
    private int id;

    private String idClient;

    private String idDescription;

    private String process;

    private String message;

    private Map<String, Objects> other;
}
