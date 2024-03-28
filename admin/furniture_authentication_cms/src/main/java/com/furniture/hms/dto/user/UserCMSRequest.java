package com.furniture.hms.dto.user;

import java.math.BigInteger;

import com.furniture.hms.enums.UserEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCMSRequest {

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String password;

    private String address;

    private String birthday;

    private String role;

    private UserEnum status;

    private String nation;

    private BigInteger phone;
}
