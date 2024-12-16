package com.techblog.TechBlog.dtos.news;

import com.techblog.TechBlog.dtos.author.AuthorDetailsDto;
import com.techblog.TechBlog.dtos.category.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDashboardDto {
    private Long id;
    private String title;
    private String photoUrl;
    private CategoryDto category;
    private AuthorDetailsDto author;
}
