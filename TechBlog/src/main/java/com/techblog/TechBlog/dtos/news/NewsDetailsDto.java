package com.techblog.TechBlog.dtos.news;


import com.techblog.TechBlog.dtos.author.AuthorDetailsDto;
import com.techblog.TechBlog.dtos.author.AuthorDto;
import com.techblog.TechBlog.dtos.category.CategoryDto;
import com.techblog.TechBlog.model.Author;
import com.techblog.TechBlog.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDetailsDto {
    private Long id;
    private String title;
    private String editor1; // Short description
    private String editor2;
    private String photoUrl;
    private AuthorDetailsDto author;
    private CategoryDto category;
    private Long views;
}
