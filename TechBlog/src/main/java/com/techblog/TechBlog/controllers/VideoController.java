package com.techblog.TechBlog.controllers;

import com.techblog.TechBlog.dtos.category.CategoryDetailsDto;
import com.techblog.TechBlog.dtos.category.CategoryFooterDto;
import com.techblog.TechBlog.dtos.news.PopularNewsDto;
import com.techblog.TechBlog.dtos.video.VideoDetailDto;
import com.techblog.TechBlog.model.Video;
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
public class VideoController {

    private final VideoService videoService;
    private final NewsService newsService;
    private final CategoryService categoryService;

    @GetMapping("/videos")
    public String videos(Model model){
        List<VideoDetailDto> videos = videoService.getAllVideos();
        List<VideoDetailDto> trendVideos = videoService.getTrendVideos();
        List<PopularNewsDto> popularNews = newsService.getPopularNews();
        List<CategoryDetailsDto> categories = categoryService.getCategories();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("categoriesFooter",categoriesFooter);
        model.addAttribute("categories",categories);
        model.addAttribute("popularNews",popularNews);
        model.addAttribute("trendVideos",trendVideos);
        model.addAttribute("videos",videos);
        return "videos.html";
    }

    @GetMapping("/videos/detail/{id}")
    public String videoDetails(@PathVariable Long id,Model model){
        Video videoDetail = videoService.getVideoDetail(id);
        List<VideoDetailDto> trendVideos = videoService.getTrendVideos();
        List<PopularNewsDto> popularNews = newsService.getPopularNews();
        List<CategoryDetailsDto> categories = categoryService.getCategories();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("categoriesFooter",categoriesFooter);
        model.addAttribute("categories",categories);
        model.addAttribute("popularNews",popularNews);
        model.addAttribute("trendVideos",trendVideos);
        model.addAttribute("videoDetail",videoDetail);
        return "videos-detail.html";
    }

}
