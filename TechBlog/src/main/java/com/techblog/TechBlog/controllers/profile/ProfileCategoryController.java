package com.techblog.TechBlog.controllers.profile;

import com.techblog.TechBlog.dtos.category.CategoryDto;
import com.techblog.TechBlog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfileCategoryController {

    private final CategoryService categoryService;

    @GetMapping("/profile/category")
    public String category(Model model){
        List<CategoryDto> categoryDtos = categoryService.allCategories();
        model.addAttribute("categories", categoryDtos);
        return "/profile/category/index.html";
    }
}
