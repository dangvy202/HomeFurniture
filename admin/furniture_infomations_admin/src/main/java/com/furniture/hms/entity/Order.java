package com.furniture.hms.entity;

import java.math.BigDecimal;
import java.time.Instant;

import com.furniture.hms.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer id;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @Column(name = "total_order")
    private BigDecimal totalOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user ", referencedColumnName = "id_user")
    private User user;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Instant updateDate;
}
