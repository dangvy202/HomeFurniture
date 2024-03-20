package com.furniture.hms.dto.user;

import java.math.BigInteger;
import java.util.Date;

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
public class UserRequest {

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String password;

    private String address;

    private Date birthday;

    private String role;

    private String nation;

    private BigInteger phone;

    private String picture;

    private Date updateDate;
}
