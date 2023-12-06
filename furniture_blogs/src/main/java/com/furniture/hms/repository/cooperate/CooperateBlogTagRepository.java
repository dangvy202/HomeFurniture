package com.furniture.hms.repository.cooperate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.CooperateBlogTag;

@Repository
public interface CooperateBlogTagRepository extends JpaRepository<CooperateBlogTag, Integer> {

    @Query("SELECT c FROM CooperateBlogTag c WHERE c.tagBlog.id = :id")
    List<CooperateBlogTag> findCooperateBlogTagByTagBlog(int id);
}
