package com.furniture.hms.repository.wishlist;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.User;
import com.furniture.hms.entity.WishlistOrder;

@Repository
public interface WishlistOrderRepository extends JpaRepository<WishlistOrder, Integer> {

    Optional<WishlistOrder> findWishlistOrderByUserAndIdProduct(User user, int idProduct);
}
