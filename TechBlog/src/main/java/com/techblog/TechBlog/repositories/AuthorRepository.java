package com.techblog.TechBlog.repositories;

import com.techblog.TechBlog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("select n from Author n order by n.id ")
    List<Author> findAllByOrderByIdASC();

}
