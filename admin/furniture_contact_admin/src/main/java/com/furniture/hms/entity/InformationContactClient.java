package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Entity
@Table(name = "information_contact_client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationContactClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private int status;


    @Column(name = "create_date")
    private Instant createDate;

}
