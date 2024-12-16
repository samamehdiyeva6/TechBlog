package com.techblog.TechBlog.services.Impl;

import com.techblog.TechBlog.dtos.category.*;
import com.techblog.TechBlog.model.Category;
import com.techblog.TechBlog.repositories.CategoryRepository;
import com.techblog.TechBlog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CategoryDetailsDto> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDetailsDto> categoryDetails = categories.stream().map(cat -> modelMapper.map(cat,CategoryDetailsDto.class)).toList();
        return categoryDetails;
    }

    @Override
    public CategoryDetailsDto getCategoryDetails(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        CategoryDetailsDto categoryDetails = modelMapper.map(category,CategoryDetailsDto.class);
        return categoryDetails;
    }


    @Override
    public boolean updateCategory(CategoryUpdateDto categoryUpdateDto, Long id) {
        Category existingCategory = categoryRepository.findByName(categoryUpdateDto.getName());
        if(existingCategory!=null && !existingCategory.getId().equals(id)) {
            return false;
        }

        Category category = categoryRepository.findById(id).orElseThrow();
        if(category!=null){
            category.setName(categoryUpdateDto.getName());
            categoryRepository.save(category);
            return true;
        }
        return false;
    }


    @Override
    public CategoryUpdateDto findUpdateCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return modelMapper.map(category,CategoryUpdateDto.class);
    }

    @Override
    public List<CategoryDto> allCategories() {
        List<Category> categories = categoryRepository.findAllByASC();
        List<CategoryDto> categoryDtos = categories.stream().map(cat ->modelMapper.map(cat, CategoryDto.class)).toList();
        return categoryDtos;
    }

    @Override
    public boolean findCategory(CategoryCreateDto categoryCreateDto) {
        Category findCategory = categoryRepository.findByName(categoryCreateDto.getName());
        if(findCategory != null){
            return false;
        }
        Category category = new Category();
        category.setName(categoryCreateDto.getName());
        categoryRepository.save(category);
        return true;
    }

    @Override
    public List<CategoryCreateDto> getAllCategories() {
        List<Category> cat = categoryRepository.findAll();
        List<CategoryCreateDto> categories = cat.stream().map(c ->modelMapper.map(c,CategoryCreateDto.class)).toList();
        return categories;
    }

    @Override
    public List<CategoryFooterDto> getFooterCategories() {
        Pageable pageable = PageRequest.of(0, 5);
        List<Category> categories = categoryRepository.findAllWithLimit(pageable);
        List<CategoryFooterDto> categoryFooterDtoList = new ArrayList<>();

        for(Category category: categories){
            CategoryFooterDto categoryFooterDto = new CategoryFooterDto();
            categoryFooterDto.setId(category.getId());
            categoryFooterDto.setCategoryName(category.getName());
            categoryFooterDto.setCountNews(category.getNews().stream().count());
            categoryFooterDtoList.add(categoryFooterDto);
        }

        return categoryFooterDtoList;
    }
}
