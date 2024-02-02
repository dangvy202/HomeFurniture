package com.furniture.hms.repository.orderDetail;

import com.furniture.hms.entity.OrderDetail;
import com.furniture.hms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
    List<OrderDetail> findOrderByUser(User email);

    OrderDetail findOrderByOrderCode(String orderCode);

    @Modifying
    @Transactional
    @Query("DELETE FROM OrderDetail o where o.orderCode = :orderCode")
    void deleteOrderByOrderId(String orderCode);
}
