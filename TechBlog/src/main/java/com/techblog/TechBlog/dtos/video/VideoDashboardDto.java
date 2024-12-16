package com.techblog.TechBlog.dtos.video;

import com.techblog.TechBlog.dtos.author.AuthorDto;
import com.techblog.TechBlog.model.Author;
import lombok.Data;

@Data
public class VideoDashboardDto {
    private Long id;
    private String title;
    private String videoUrl;
    private AuthorDto author;
}
