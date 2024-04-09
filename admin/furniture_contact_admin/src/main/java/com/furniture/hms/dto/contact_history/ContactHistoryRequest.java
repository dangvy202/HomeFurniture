package com.furniture.hms.dto.contact_history;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.hms.enums.ProcessEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ContactHistoryRequest {

    @JsonProperty("id_history")
    private int id;

    @JsonProperty("id_client")
    private String idClient;

    @JsonProperty("id_description")
    private String idDescription;

    @JsonProperty("process")
    private ProcessEnum process;

    @JsonProperty("message")
    private String message;

}
