package com.furniture.hms.repository.informationOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.InformationOrder;

import java.util.Optional;

@Repository
public interface InformationOrderRepository extends JpaRepository<InformationOrder, Integer> {
    @Query("SELECT i FROM InformationOrder i WHERE i.order.id = :idOrder")
    Optional<InformationOrder> findInformationOrderByIdOrder(int idOrder);
}
