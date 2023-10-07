package com.furniture.hms.repository.product;

import com.furniture.hms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.category.id = :idCategory")
    List<Product> findByCategory(Integer idCategory);

    @Query("SELECT p FROM Product p WHERE p.room.id = :idRoom")
    List<Product> findByRoom(Integer idRoom);

    List<Product> findByProductNameContaining(String nameProduct);
}
