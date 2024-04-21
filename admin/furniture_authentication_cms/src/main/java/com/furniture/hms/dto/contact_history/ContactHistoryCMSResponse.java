package com.furniture.hms.dto.contact_history;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
@Setter
@Getter
public class ContactHistoryCMSResponse {
    private int id;

    private String process;

    private String message;

    private Map<String, Object> other;
}
