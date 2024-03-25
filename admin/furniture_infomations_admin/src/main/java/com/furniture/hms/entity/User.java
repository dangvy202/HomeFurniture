package com.furniture.hms.entity;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Date;

import com.furniture.hms.enums.UserEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserEnum status;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "role")
    private String role;

    @Column(name = "nation")
    private String nation;

    @Column(name = "phone")
    private BigInteger phone;

    @Column(name = "picture")
    private String picture;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Instant updateDate;
}
