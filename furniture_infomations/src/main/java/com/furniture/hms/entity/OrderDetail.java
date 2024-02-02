package com.furniture.hms.entity;

import com.furniture.hms.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Entity
@Table(name = "orders_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private Integer id;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @Column(name = "order_quantity")
    private Integer orderQuantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user " , referencedColumnName = "id_user")
    private User user;

    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Instant updateDate;
}
