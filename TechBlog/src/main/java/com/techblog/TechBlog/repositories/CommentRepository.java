package com.techblog.TechBlog.repositories;

import com.techblog.TechBlog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByNewsId(Long id);
}
