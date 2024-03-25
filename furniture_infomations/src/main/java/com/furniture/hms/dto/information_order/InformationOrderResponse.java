package com.furniture.hms.dto.information_order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationOrderResponse {

    private Boolean status;

    private String error;

    private String message;

    InformationOrderDetail informationOrderDetail;

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class InformationOrderDetail {
	private String address;

	private String email;

	private String phone;

	private String userName;

    }
}
