package com.furniture.hms.repository.banner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
}
