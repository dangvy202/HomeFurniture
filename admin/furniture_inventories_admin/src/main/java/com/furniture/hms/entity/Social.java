package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "social")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Social {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_social")
    private Integer id;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "twiter")
    private String twiter;

    @Column(name = "tiktok")
    private String tiktok;

    @Column(name = "instagram")
    private String instagram;

}
