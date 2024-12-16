package com.techblog.TechBlog.controllers;

import com.techblog.TechBlog.dtos.category.CategoryFooterDto;
import com.techblog.TechBlog.dtos.comment.CommentCreateDto;
import com.techblog.TechBlog.dtos.comment.CommentListDto;
import com.techblog.TechBlog.dtos.news.PopularNewsDto;
import com.techblog.TechBlog.dtos.category.CategoryDetailsDto;
import com.techblog.TechBlog.dtos.news.NewsDetailsDto;
import com.techblog.TechBlog.dtos.video.VideoDetailDto;
import com.techblog.TechBlog.services.CategoryService;
import com.techblog.TechBlog.services.CommentService;
import com.techblog.TechBlog.services.NewsService;
import com.techblog.TechBlog.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;
    private final VideoService videoService;
    private final CategoryService categoryService;
    private final CommentService commentService;

    @GetMapping("/news/detail/{id}")
    public String newsDetails(@PathVariable Long id, Model model){
        NewsDetailsDto newsDetails = newsService.getNews(id);
        List<VideoDetailDto> trendVideos = videoService.getTrendVideos();
        List<PopularNewsDto> popularNews = newsService.getPopularNews();
        List<CategoryDetailsDto> categories = categoryService.getCategories();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();
        List<CommentListDto> commentListDto = commentService.getNewsComments(id);

        model.addAttribute("comments",commentListDto);
        model.addAttribute("categoriesFooter",categoriesFooter);
        model.addAttribute("categories",categories);
        model.addAttribute("popularNews",popularNews);
        model.addAttribute("trendVideos",trendVideos);
        model.addAttribute("newsDetails",newsDetails);
        return "news-detail.html";
    }

    @PostMapping("/news/detail/{id}")
    public String addComment(@PathVariable Long id, Principal principal, CommentCreateDto commentCreateDto,Model model){
        String email = principal.getName();
        commentCreateDto.setUserEmail(email);
        commentCreateDto.setNewsId(id);
        commentService.createComment(commentCreateDto);
        return "redirect:/news/detail/"+id;
    }
}
