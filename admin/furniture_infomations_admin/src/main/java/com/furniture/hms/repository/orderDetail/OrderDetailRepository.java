package com.furniture.hms.repository.orderDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.OrderDetail;
import com.furniture.hms.entity.User;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    List<OrderDetail> findOrderDetailByOrderCode(String orderCode);

    @Query("DELETE FROM OrderDetail o where o.orderCode = :orderCode")
    void deleteOrderByOrderId(String orderCode);
}
