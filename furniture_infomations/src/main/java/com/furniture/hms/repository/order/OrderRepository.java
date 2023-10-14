package com.furniture.hms.repository.order;

import com.furniture.hms.entity.Order;
import com.furniture.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findOrderByUser(User email);
}
