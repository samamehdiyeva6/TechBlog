package com.techblog.TechBlog.repositories;

import com.techblog.TechBlog.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video,Long> {
    @Query("select n from Video n order by n.id desc")
    List<Video> getAllVideos();

    @Query("select n from Video n order by n.views desc limit 3")
    List<Video> trendVideos();

    @Query("select n from Video n where n.author.id=:id order by n.id desc")
    List<Video> getAuthorVideos(@Param("id") Long id);

    @Query("select n from Video n order by n.id")
    List<Video> findAllByOrderByIdASC();
}
