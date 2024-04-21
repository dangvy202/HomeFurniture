package com.furniture.hms.dto.client_subscribe;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClientSubscribeCMSResponse {
    private int id;

    private String email;

    private String checkMail;
}
