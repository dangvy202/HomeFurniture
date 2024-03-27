package com.furniture.hms.repository.orderDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    List<OrderDetail> findOrderDetailByOrderCode(String orderCode);

    @Modifying
    @Query("DELETE FROM OrderDetail o where o.orderCode = :orderCode")
    void deleteOrderByOrderId(String orderCode);
}
