package com.techblog.TechBlog.dtos.news;

import com.techblog.TechBlog.model.Author;
import lombok.Data;

@Data
public class PopularNewsDto {
    private Long id;
    private String title;
    private String photoUrl;
    private Author author;
}
