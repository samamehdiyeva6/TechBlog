package com.techblog.TechBlog.controllers.dashboard;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginControllers {

    @GetMapping("/login")
    public String login(){
        return "/dashboard/login.html";
    }

}
