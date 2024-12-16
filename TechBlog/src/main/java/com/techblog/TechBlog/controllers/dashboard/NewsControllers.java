package com.techblog.TechBlog.controllers.dashboard;

import com.techblog.TechBlog.dtos.news.NewsDashboardDto;
import com.techblog.TechBlog.dtos.news.NewsDeleteDto;
import com.techblog.TechBlog.services.AuthorService;
import com.techblog.TechBlog.services.CategoryService;
import com.techblog.TechBlog.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewsControllers {

    private final NewsService newsService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @GetMapping("/admin/news")
    public String news(Model model){
        List<NewsDashboardDto> news = newsService.allNews();
        model.addAttribute("n",news);
        return "/dashboard/news/news.html";
    }

    @PostMapping("/admin/news/delete/{id}")
    public String delete(@PathVariable Long id){
        newsService.deleteNews(id);
        return "redirect:/admin/news";
    }
}
