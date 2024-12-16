package com.techblog.TechBlog.services;

import com.techblog.TechBlog.dtos.video.VideoDashboardDto;
import com.techblog.TechBlog.dtos.video.VideoDetailDto;
import com.techblog.TechBlog.dtos.video.VideoUpdateDto;
import com.techblog.TechBlog.model.Video;

import java.util.List;

public interface VideoService {
    List<VideoDetailDto> getAllVideos();

    List<VideoDetailDto> getTrendVideos();

    Video getVideoDetail(Long id);

    List<VideoDetailDto> getAuthorVideos(Long id);

//    CRUD
    List<VideoDashboardDto> getDashboardVideos();

    void deleteVideo(Long id);
}
