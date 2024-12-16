package com.techblog.TechBlog.services.Impl;

import com.techblog.TechBlog.dtos.video.VideoDashboardDto;
import com.techblog.TechBlog.dtos.video.VideoDetailDto;
import com.techblog.TechBlog.dtos.video.VideoUpdateDto;
import com.techblog.TechBlog.model.Video;
import com.techblog.TechBlog.repositories.VideoRepository;
import com.techblog.TechBlog.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<VideoDetailDto> getAllVideos() {
        List<Video> videos = videoRepository.getAllVideos();
        List<VideoDetailDto> allVideos = videos.stream().map(v -> modelMapper.map(v,VideoDetailDto.class)).toList();
        return allVideos;
    }

    @Override
    public List<VideoDetailDto> getTrendVideos() {
        List<Video> videos = videoRepository.trendVideos();
        List<VideoDetailDto> trendVideo = videos.stream().map(v -> modelMapper.map(v, VideoDetailDto.class)).toList();
        return trendVideo;
    }

    @Override
    public Video getVideoDetail(Long id) {
        Video videosDetail = videoRepository.findById(id).orElseThrow();
        return videosDetail;
    }

    @Override
    public List<VideoDetailDto> getAuthorVideos(Long id) {
        List<Video> authorVideos = videoRepository.getAuthorVideos(id);
        List<VideoDetailDto> videoDetails = authorVideos.stream().map(a ->modelMapper.map(a,VideoDetailDto.class)).toList();
        return videoDetails;
    }


//  CRUD

    @Override
    public List<VideoDashboardDto> getDashboardVideos() {
        List<Video> videos = videoRepository.findAllByOrderByIdASC();
        return videos.stream().map(v ->modelMapper.map(v,VideoDashboardDto.class)).toList();
    }

    @Override
    public void deleteVideo(Long id) {
        if(videoRepository.existsById(id)){
            videoRepository.deleteById(id);
        }
        else{
            throw new IllegalArgumentException("News with ID " + id + " not found");
        }
    }


}
