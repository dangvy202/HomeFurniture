package com.furniture.hms.entity;

import com.furniture.hms.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Entity
@Table(name = "information_contact_admin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationContactAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "hotline")
    private String hotline;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Instant updateDate;
}
