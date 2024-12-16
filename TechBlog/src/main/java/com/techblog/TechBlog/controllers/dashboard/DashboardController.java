package com.techblog.TechBlog.controllers.dashboard;

import com.techblog.TechBlog.model.User;
import com.techblog.TechBlog.services.CategoryService;
import com.techblog.TechBlog.services.NewsService;
import com.techblog.TechBlog.services.UserService;
import com.techblog.TechBlog.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final CategoryService categoryService;
    private final NewsService newsService;
    private final VideoService videoService;
    private final UserService userService;

    @GetMapping("/admin")
    public String admin(Model model){
        long countCategory = categoryService.allCategories().stream().count();
        long countNews = newsService.allNews().stream().count();
        long countVideo = videoService.getAllVideos().stream().count();
        long countUser = userService.getAllUser();

        model.addAttribute("categoryCount",countCategory);
        model.addAttribute("countNews",countNews);
        model.addAttribute("countVideo",countVideo);
        model.addAttribute("countUser",countUser);
        return "/dashboard/index.html";
    }
}
