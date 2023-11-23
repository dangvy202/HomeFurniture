package com.furniture.hms.repository.category;

import com.furniture.hms.entity.CategoryBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryBlogRepository extends JpaRepository<CategoryBlog,Integer> {

}
