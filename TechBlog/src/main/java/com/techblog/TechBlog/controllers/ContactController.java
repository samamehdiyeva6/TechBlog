package com.techblog.TechBlog.controllers;

import com.techblog.TechBlog.dtos.category.CategoryDetailsDto;
import com.techblog.TechBlog.dtos.category.CategoryFooterDto;
import com.techblog.TechBlog.dtos.contact.ContactSendDto;
import com.techblog.TechBlog.services.CategoryService;
import com.techblog.TechBlog.services.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final CategoryService categoryService;

    @GetMapping("/contact")
    public String Contact(Model model,String success){
        List<CategoryDetailsDto> categories = categoryService.getCategories();
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("categoriesFooter",categoriesFooter);
        model.addAttribute("categories",categories);
        model.addAttribute("contactSendDto",new ContactSendDto());
        if(success==null){
            model.addAttribute("success",false);
            return "contact.html";
        }else{
            model.addAttribute("success",true);
        }
        return "contact.html";
    }

    @PostMapping("/contact")
    public String contact(@Valid ContactSendDto contactSendDto, BindingResult bindingResult,Model model){
        List<CategoryFooterDto> categoriesFooter = categoryService.getFooterCategories();

        model.addAttribute("categoriesFooter",categoriesFooter);
        if(bindingResult.hasErrors()){
            return "contact.html";
        }
        contactService.sendEmail(contactSendDto);
        return "redirect:/contact?success=true";
    }
}
