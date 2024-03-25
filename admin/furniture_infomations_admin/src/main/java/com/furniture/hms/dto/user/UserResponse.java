package com.furniture.hms.dto.user;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;

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
public class UserResponse {

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private UserEnum status;

    private String password;

    private String address;

    private Date birthday;

    private String role;

    private String nation;

    private BigInteger phone;

    private String picture;

    private Instant createDate;

    private Date updateDate;
}
