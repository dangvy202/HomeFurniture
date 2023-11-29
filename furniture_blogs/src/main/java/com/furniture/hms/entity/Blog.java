package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer id;

    @Column(name = "blog_title")
    private String blogTitle;

    @Column(name = "status")
    private Integer status;

    @Column(name = "content")
    private String content;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private CategoryBlog categoryBlog;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;
}
