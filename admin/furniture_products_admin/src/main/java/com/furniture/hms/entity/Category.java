package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_picture")
    private String categoryPicture;

    @Column(name = "category_redirect")
    private String categoryRedirect;

    @Column(name = "status")
    private int status;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Instant updateDate;

}
