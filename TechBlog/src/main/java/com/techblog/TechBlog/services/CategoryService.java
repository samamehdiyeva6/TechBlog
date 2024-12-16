package com.techblog.TechBlog.services;


import com.techblog.TechBlog.dtos.category.*;

import java.util.List;

public interface CategoryService{
    List<CategoryDetailsDto> getCategories();

    CategoryDetailsDto getCategoryDetails(Long id);

    boolean updateCategory(CategoryUpdateDto categoryUpdateDto,Long id);

    CategoryUpdateDto findUpdateCategory(Long id);

    List<CategoryDto> allCategories();

    boolean findCategory(CategoryCreateDto categoryCreateDto);

    List<CategoryCreateDto> getAllCategories();

    List<CategoryFooterDto> getFooterCategories();
}
