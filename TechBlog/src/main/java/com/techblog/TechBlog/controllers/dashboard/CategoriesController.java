package com.techblog.TechBlog.controllers.dashboard;

import com.techblog.TechBlog.dtos.category.CategoryCreateDto;
import com.techblog.TechBlog.dtos.category.CategoryDto;
import com.techblog.TechBlog.dtos.category.CategoryUpdateDto;
import com.techblog.TechBlog.model.Category;
import com.techblog.TechBlog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoriesController {

    private final CategoryService categoryService;

    @GetMapping("/admin/category")
    public String category(Model model){
        List<CategoryDto> categories = categoryService.allCategories();

        model.addAttribute("categories",categories);
        return "/dashboard/category/category.html";
    }

    @GetMapping("/admin/category/create")
    public String create(){
        return "/dashboard/category/create.html";
    }

    @PostMapping("/admin/category/create")
    public String create(@Valid @ModelAttribute(value="name") CategoryCreateDto categoryCreateDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/dashboard/category/create.html";
        }
        if(categoryService.findCategory(categoryCreateDto)==false){
            return "/dashboard/category/create.html";
        }
        return "redirect:/admin/category";
    }

    @GetMapping("/admin/category/update/{id}")
    public String update(@PathVariable Long id,Model model){
        CategoryUpdateDto categoryUpdateDto = categoryService.findUpdateCategory(id);
        model.addAttribute("category",categoryUpdateDto);
        return "/dashboard/category/update.html";
    }

    @PostMapping("/admin/category/update/{id}")
    public String update(@PathVariable Long id, Model model, @Valid CategoryUpdateDto categoryUpdateDto,BindingResult bindingResult){
        CategoryUpdateDto getCategory = categoryService.findUpdateCategory(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("category",getCategory);
            return "/dashboard/category/update.html";
        }
        if(categoryService.updateCategory(categoryUpdateDto,id)==false){
            model.addAttribute("category",getCategory);
            return "/dashboard/category/update.html";
        }
        categoryService.updateCategory(categoryUpdateDto,id);
        return "redirect:/admin/category";
    }


}

