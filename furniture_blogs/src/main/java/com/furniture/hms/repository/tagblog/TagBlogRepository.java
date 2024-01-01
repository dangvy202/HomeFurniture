package com.furniture.hms.repository.tagblog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.TagBlog;

@Repository
public interface TagBlogRepository extends JpaRepository<TagBlog, Integer> {
}
