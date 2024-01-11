package com.furniture.hms.dto.clientSubscribe;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
public class ClientSubscribeResponse {
    private Boolean status;

    private String error;

    private String message;

    private ClientSubscribeDetail clientSubscribeDetail;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ClientSubscribeDetail {

        private int id;

        private String email;

        private String checkMail;
    }
}
