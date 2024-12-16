package com.techblog.TechBlog.dtos.video;

import com.techblog.TechBlog.model.Author;
import lombok.Data;

@Data
public class VideoDetailDto {
    private Long id;
    private String title;
    private String videoUrl;
    private Long views;
    private Author author;
}

