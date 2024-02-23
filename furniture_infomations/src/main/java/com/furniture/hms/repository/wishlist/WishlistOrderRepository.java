package com.furniture.hms.repository.wishlist;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.User;
import com.furniture.hms.entity.WishlistOrder;

import jakarta.transaction.Transactional;

@Repository
public interface WishlistOrderRepository extends JpaRepository<WishlistOrder, Integer> {

    Optional<WishlistOrder> findWishlistOrderByUserAndIdProduct(User user, int idProduct);

    List<WishlistOrder> findWishlistOrderByUser(User user);

    @Transactional
    @Modifying
    @Query("DELETE FROM WishlistOrder w WHERE w.idProduct = :idProduct")
    void deleteWishlistOrderByIdProduct(int idProduct);
}
