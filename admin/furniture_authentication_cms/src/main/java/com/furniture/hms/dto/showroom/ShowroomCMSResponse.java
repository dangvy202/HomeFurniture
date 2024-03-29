package com.furniture.hms.dto.showroom;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ShowroomCMSResponse {
    private String address;
    private String dayOpen;
    private String timeOpen;
    private String mail;
    private String phone;
}
