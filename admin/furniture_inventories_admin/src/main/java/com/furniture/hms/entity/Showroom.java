package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "showroom")
@Getter
@Setter
@NoArgsConstructor
public class Showroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_showroom")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "day_open")
    private String dayOpen;

    @Column(name = "time_open")
    private String timeOpen;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone")
    private String phone;
}
