package com.techblog.TechBlog.controllers;

import com.techblog.TechBlog.dtos.user.SignInDto;
import com.techblog.TechBlog.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/admin/login")
    public String login(){
        return "dashboard/login.html";
    }

    @GetMapping("/signIn")
    public String signIn(Model model){
        model.addAttribute("signInDto",new SignInDto());
        return "dashboard/login.html";
    }


    @PostMapping("/signIn")
    public String signIn(@Valid SignInDto signInDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "dashboard/login.html";
        }
        boolean res = userService.signIn(signInDto);
        if(!res){
            return "/dashboard/login.html";
        }
        return "redirect:/login";
    }
}
