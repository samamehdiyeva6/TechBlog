package com.techblog.TechBlog.dtos.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CategoryUpdateDto {
    @NotNull
    @NotBlank
    private String name;
}
