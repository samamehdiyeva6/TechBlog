package com.techblog.TechBlog.dtos.category;

import lombok.Data;

@Data
public class CategoryFooterDto {
    private Long id;
    private String categoryName;
    private Long countNews;
}

