package com.techblog.TechBlog.repositories;

import com.techblog.TechBlog.model.Author;
import com.techblog.TechBlog.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface NewsRepository extends JpaRepository<News,Long> {
    @Query("select n from News n order by n.views desc")
    List<News> getFirstNews();

    @Query("select n from News n order by n.views desc limit 2 offset 1")
    List<News> getTwoNews();

    @Query("select n from News n order by n.id ")
    List<News> findAllByOrderByIdASC();

    @Query("select n from News n where n.author.id=:id order by n.id desc")
    List<News> getAuthorNews(@Param("id") Long id);

    @Query("select n from News n order by n.views desc limit 3")
    List<News> getPopularNews();

    @Query("select n from News n where n.category.id=:id order by n.id desc")
    List<News> getCategoryNews(@Param("id") Long id);


//    List<News> findByAuthorId(Long authorId);

}
