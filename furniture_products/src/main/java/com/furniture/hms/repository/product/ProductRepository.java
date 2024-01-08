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

    @Query("SELECT p FROM Product p WHERE " +
            "p.category.id IN (SELECT c.id FROM Category c WHERE c.categoryRedirect = :redirect)")
    List<Product> findProductByCategoryRedirect(String redirect);

    @Query("SELECT p FROM Product p WHERE " +
            "p.room.id IN (SELECT r.id FROM Room r WHERE r.roomRedirect = :redirect)")
    List<Product> findProductByRoomRedirect(String redirect);


    List<Product> findByProductNameContaining(String nameProduct);
}
