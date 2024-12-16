package com.techblog.TechBlog.controllers;

import com.techblog.TechBlog.dtos.category.CategoryDetailsDto;
import com.techblog.TechBlog.dtos.category.CategoryFooterDto;
import com.techblog.TechBlog.dtos.news.NewsDetailsDto;
import com.techblog.TechBlog.dtos.news.PopularNewsDto;
import com.techblog.TechBlog.dtos.video.VideoDetailDto;
import com.techblog.TechBlog.services.CategoryService;
import com.techblog.TechBlog.services.NewsService;
import com.techblog.TechBlog.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final NewsService newsService;
    private final VideoService videoService;
    private final CategoryService categoryService;



    @GetMapping("/category/news/{id}")
    public String category(@PathVariable Long id, Model model){
        CategoryDetailsDto categoryDetails = categoryService.getCategoryDetails(id);
        List<NewsDetailsDto> categoryNews = newsService.getCategoryNews(id);
        List<PopularNewsDto> popularNews = newsService.getPopularNews();
        List<VideoDetailDto> trendVideos = videoService.getTrendVideos();
        List<CategoryDetailsDto> categories = categoryService.getCategories();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("categoriesFooter",categoriesFooter);
        model.addAttribute("categories",categories);
        model.addAttribute("popularNews",popularNews);
        model.addAttribute("trendVideos",trendVideos);
        model.addAttribute("categoryNews",categoryNews);
        model.addAttribute("categoryDetails",categoryDetails);
        return "category.html";
    }
}

