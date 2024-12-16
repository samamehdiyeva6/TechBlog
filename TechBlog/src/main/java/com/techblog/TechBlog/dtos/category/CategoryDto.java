package com.techblog.TechBlog.dtos.category;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    @NotNull
    private String name;
}
