package com.techblog.TechBlog.repositories;

import com.techblog.TechBlog.model.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);

    @Query("SELECT c, COUNT(n.id) AS newsCount FROM Category c LEFT JOIN c.news n GROUP BY c ORDER BY COUNT(n.id) desc")
    List<Category> findAllWithLimit(Pageable pageable);

    @Query("select c from Category c order by c.id")
    List<Category> findAllByASC();
}
