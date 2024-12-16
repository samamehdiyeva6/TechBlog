package com.techblog.TechBlog.controllers.profile;

import com.techblog.TechBlog.dtos.news.NewsDashboardDto;
import com.techblog.TechBlog.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfileNewsController {

    private final NewsService newsService;

    @GetMapping("/profile/news")
    public String news(Model model){
        List<NewsDashboardDto> news = newsService.allNews();
        model.addAttribute("n",news);
        return "/profile/news/index.html";
    }
}
