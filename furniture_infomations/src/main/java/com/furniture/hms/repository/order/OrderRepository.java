package com.furniture.hms.repository.order;

import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findOrderByUser(User email);

    Order findOrderByOrderId(String orderId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Order o where o.orderId = :orderId")
    void deleteOrderByOrderId(String orderId);
}
