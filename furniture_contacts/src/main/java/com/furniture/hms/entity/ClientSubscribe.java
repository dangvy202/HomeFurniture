package com.furniture.hms.entity;

import com.furniture.hms.enums.CheckMailEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client_subscribe")
@Entity
@Builder
public class ClientSubscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscribe")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "check_mail")
    @Enumerated(EnumType.STRING)
    private CheckMailEnum checkMail;

    @Column(name = "create_date")
    private Instant createDate;

}
