package com.techblog.TechBlog.controllers.profile;

import com.techblog.TechBlog.dtos.video.VideoDashboardDto;
import com.techblog.TechBlog.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProfileVideoController {

    private final VideoService videoService;

    @GetMapping("/profile/video")
    public String video(Model model){
        List<VideoDashboardDto> videos = videoService.getDashboardVideos();
        model.addAttribute("videos",videos);
        return "/profile/video/index.html";
    }
}
