package com.furniture.hms.repository.wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.WishlistOrder;

@Repository
public interface WishlistOrderRepository extends JpaRepository<WishlistOrder, Integer> {
}
