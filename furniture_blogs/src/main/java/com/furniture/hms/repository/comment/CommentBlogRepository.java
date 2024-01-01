package com.furniture.hms.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.furniture.hms.entity.Comment;

@Repository
public interface CommentBlogRepository extends JpaRepository<Comment, Integer> {

    @Query("SELECT COUNT(c.content) FROM Comment c WHERE c.blog.id = :idBlog")
    int countByIdBlog(int idBlog);

    @Query("SELECT c FROM Comment c WHERE c.blog.id = :id")
    List<Comment> findCommentByIdBlog(int id);
}
