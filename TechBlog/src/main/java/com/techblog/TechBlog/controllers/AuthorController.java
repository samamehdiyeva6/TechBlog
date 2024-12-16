package com.techblog.TechBlog.controllers;

import com.techblog.TechBlog.dtos.author.AuthorDetailsDto;
import com.techblog.TechBlog.dtos.category.CategoryDetailsDto;
import com.techblog.TechBlog.dtos.category.CategoryFooterDto;
import com.techblog.TechBlog.dtos.news.NewsDetailsDto;
import com.techblog.TechBlog.dtos.news.PopularNewsDto;
import com.techblog.TechBlog.dtos.video.VideoDetailDto;
import com.techblog.TechBlog.services.AuthorService;
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
public class AuthorController {

    private final AuthorService authorService;
    private final NewsService newsService;
    private final VideoService videoService;
    private final CategoryService categoryService;


    @GetMapping("/news/author/detail/{id}")
    public String authorDetail(@PathVariable Long id, Model model){
        AuthorDetailsDto authorDetails = authorService.getAuthorDetails(id);
        List<NewsDetailsDto> authorNews = newsService.getAuthorNews(id);
        List<VideoDetailDto> trendVideos = videoService.getTrendVideos();
        List<PopularNewsDto> popularNews = newsService.getPopularNews();
        List<CategoryDetailsDto> categories = categoryService.getCategories();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("categoriesFooter",categoriesFooter);
        model.addAttribute("categories",categories);
        model.addAttribute("popularNews",popularNews);
        model.addAttribute("authorDetails",authorDetails);
        model.addAttribute("authorNews",authorNews);
        model.addAttribute("trendVideos",trendVideos);
        return "author.html";
    }

    @GetMapping("/videos/author/detail/{id}")
    public String authorVideos(@PathVariable Long id, Model model){
        AuthorDetailsDto authorDetails = authorService.getAuthorDetails(id);
        List<VideoDetailDto> authorVideos = videoService.getAuthorVideos(id);
        List<VideoDetailDto> trendVideos = videoService.getTrendVideos();
        List<PopularNewsDto> popularNews = newsService.getPopularNews();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("categoriesFooter",categoriesFooter);
        model.addAttribute("popularNews",popularNews);
        model.addAttribute("authorDetails",authorDetails);
        model.addAttribute("authorVideos",authorVideos);
        model.addAttribute("trendVideos",trendVideos);
        return "video-author.html";
    }


}
