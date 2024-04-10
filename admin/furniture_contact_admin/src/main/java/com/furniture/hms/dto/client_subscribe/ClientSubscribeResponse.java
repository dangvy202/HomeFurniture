package com.furniture.hms.dto.client_subscribe;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
public class ClientSubscribeResponse {
    private int id;

    private String email;

    private String checkMail;
}
