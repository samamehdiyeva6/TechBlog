package com.techblog.TechBlog.dtos.video;

import com.techblog.TechBlog.dtos.author.AuthorDto;
import com.techblog.TechBlog.model.Author;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class VideoUpdateDto {
    private String title;
    private String content;
    private AuthorDto author;
    private String videoUrl;
    private Long views;
}
