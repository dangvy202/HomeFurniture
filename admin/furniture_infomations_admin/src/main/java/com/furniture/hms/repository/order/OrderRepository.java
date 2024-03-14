package com.furniture.hms.repository.order;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findOrderByOrderCode(String code);

    List<Order> findOrderByUser(User user);

    @Modifying
    @Transactional
    @Query("DELETE FROM Order o where o.orderCode = :orderCode")
    void deleteOrderByOrderId(String orderCode);
}
