package com.furniture.hms.repository.inventory;

import com.furniture.hms.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByIdProduct(Integer idProduct);
}
