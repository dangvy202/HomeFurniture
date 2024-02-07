package com.furniture.hms.repository.order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findOrderByOrderCode(String code);
}
