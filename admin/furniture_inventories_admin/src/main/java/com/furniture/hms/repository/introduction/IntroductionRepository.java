package com.furniture.hms.repository.introduction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.Introduction;

@Repository
public interface IntroductionRepository extends JpaRepository<Introduction, Integer> {
}
