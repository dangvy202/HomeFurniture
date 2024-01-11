package com.furniture.hms.dto.contactHistory;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ContactHistoryResponse {
    private Boolean status;

    private String error;

    private String message;
}
