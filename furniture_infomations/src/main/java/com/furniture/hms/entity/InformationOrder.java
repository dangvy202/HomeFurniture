package com.furniture.hms.entity;

import java.math.BigInteger;
import java.time.Instant;

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
@Entity
@Table(name = "information_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_information_order")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private BigInteger phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    private Order order;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Instant updateDate;
}
