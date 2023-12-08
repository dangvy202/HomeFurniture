package com.furniture.hms.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @Column(name = "short_content")
    private String shortContent;

    @Column(name = "content")
    private String content;

    @Column(name = "blog_avatar")
    private String blogAvatar;

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
