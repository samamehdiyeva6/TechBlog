package com.techblog.TechBlog.controllers.dashboard;

import com.techblog.TechBlog.dtos.video.VideoDashboardDto;
import com.techblog.TechBlog.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VideosController {

    private final VideoService videoService;

    @GetMapping("/admin/video")
    public String video(Model model){
        List<VideoDashboardDto> videos = videoService.getDashboardVideos();
        model.addAttribute("videos",videos);
        return "/dashboard/video/video.html";
    }

    @PostMapping("/admin/video/delete/{id}")
    public String video(@PathVariable Long id){
        videoService.deleteVideo(id);
        return "redirect:/admin/video";
    }

}
