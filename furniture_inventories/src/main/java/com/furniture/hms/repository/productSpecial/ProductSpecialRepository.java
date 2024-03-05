package com.furniture.hms.repository.productSpecial;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.Banner;
import com.furniture.hms.entity.ProductSpecial;

@Repository
public interface ProductSpecialRepository extends JpaRepository<ProductSpecial, Integer> {

    List<ProductSpecial> findProductSpecialByBanner(Banner banner);
}
