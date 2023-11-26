package com.furniture.hms.repository.blog;

import com.furniture.hms.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog ,Integer> {
    @Query("SELECT b FROM Blog b WHERE b.categoryBlog.id = :id")
    List<Blog> findBlogByIdCategoryBlog(int id);
}
