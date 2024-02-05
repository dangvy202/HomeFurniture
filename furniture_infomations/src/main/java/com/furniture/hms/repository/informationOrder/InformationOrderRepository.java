package com.furniture.hms.repository.informationOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.InformationOrder;

@Repository
public interface InformationOrderRepository extends JpaRepository<InformationOrder, Integer> {

}
