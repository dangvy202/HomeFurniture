package com.furniture.hms.repository.social;

import com.furniture.hms.entity.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository extends JpaRepository<Social, Integer> {
}
