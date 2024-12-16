package com.techblog.TechBlog.controllers;

import com.techblog.TechBlog.dtos.category.CategoryDetailsDto;
import com.techblog.TechBlog.dtos.category.CategoryDto;
import com.techblog.TechBlog.dtos.category.CategoryFooterDto;
import com.techblog.TechBlog.dtos.news.PopularNewsDto;
import com.techblog.TechBlog.dtos.video.VideoDetailDto;
import com.techblog.TechBlog.model.News;
import com.techblog.TechBlog.services.CategoryService;
import com.techblog.TechBlog.services.NewsService;
import com.techblog.TechBlog.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final NewsService newsService;
    private final VideoService videoService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model, Integer pageNumber){
        Page<News> news = newsService.getAllNews(pageNumber);
        List<CategoryDetailsDto> categories = categoryService.getCategories();
        News firstNews = newsService.getFirstNews();
        List<News> twoNews = newsService.getTwoNews();
        List<PopularNewsDto> popularNews = newsService.getPopularNews();
        List<VideoDetailDto> trendVideos = videoService.getTrendVideos();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("news", news.stream().toList());
        model.addAttribute("pageCount",news.getTotalPages());
        model.addAttribute("categories",categories);
        model.addAttribute("firstNews",firstNews);
        model.addAttribute("twoNews",twoNews);
        model.addAttribute("popularNews",popularNews);
        model.addAttribute("trendVideos",trendVideos);
        model.addAttribute("categoriesFooter",categoriesFooter);

        return "index.html";
    }

    @GetMapping("/contact-us")
    public String contact(){
        return "contact.html";
    }
}
