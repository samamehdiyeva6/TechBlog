package com.techblog.TechBlog.controllers.dashboard;

import com.techblog.TechBlog.dtos.author.AuthorDto;
import com.techblog.TechBlog.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorsController {

    private final AuthorService authorService;


    @GetMapping("/admin/author")
    public String author(Model model){
        List<AuthorDto> authors = authorService.getDashboardAuthors();
        model.addAttribute("authors",authors);
        return "/dashboard/author/author.html";
    }

    @PostMapping("/admin/author/block/{id}")
    public String author(@PathVariable Long id){
        authorService.deleteAuthor(id);
        return "redirect:/admin/author";
    }

}
