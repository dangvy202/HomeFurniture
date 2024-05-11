package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "pictures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_picture")
    private Integer id;

    @Column(name = "picture_first")
    private String pictureFirst;

    @Column(name = "picture_second")
    private String pictureSecond;

    @Column(name = "picture_third")
    private String pictureThird;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;
}
