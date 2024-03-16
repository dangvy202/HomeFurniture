package com.furniture.hms.repository.informationOrder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.InformationOrder;
import com.furniture.hms.entity.Order;

@Repository
public interface InformationOrderRepository extends JpaRepository<InformationOrder, Integer> {
    @Query("SELECT i FROM InformationOrder i WHERE i.order.id = :idOrder")
    List<InformationOrder> findInformationOrderByIdOrder(int idOrder);

    @Modifying
    @Query("DELETE FROM InformationOrder i where i.order = :order")
    void deleteInformationOrderByOrder(Order order);
}
