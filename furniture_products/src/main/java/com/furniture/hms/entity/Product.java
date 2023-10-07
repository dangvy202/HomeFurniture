package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "product_saleoff")
    private BigDecimal productSaleoff;

    @Column(name = "product_color")
    private String productColor;

    @Column(name = "product_property")
    private String productProperty;

    @Column(name = "product_status")
    private Integer productStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    private Category category;

    @Column(name = "id_room")
    private Integer idRoom;

    @Column(name = "id_comment")
    private Integer idComment;

    @Column(name = "id_rating")
    private Integer idRating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_picture", referencedColumnName = "id_picture")
    private Picture picture;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Date updateDate;
}
