package com.techblog.TechBlog.services;


import com.techblog.TechBlog.dtos.news.NewsDashboardDto;
import com.techblog.TechBlog.dtos.news.NewsDetailsDto;
import com.techblog.TechBlog.dtos.news.PopularNewsDto;
import com.techblog.TechBlog.model.News;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {

    Page<News> getAllNews(Integer pageNumber);

    NewsDetailsDto getNews(Long id);

    List<News> getTwoNews();

    News getFirstNews();

    List<NewsDetailsDto> getAuthorNews(Long id);

    List<PopularNewsDto> getPopularNews();

    List<NewsDetailsDto> getCategoryNews(Long id);

//    CRUD operations

    void deleteNews(Long id);

    List<NewsDashboardDto> allNews();

    News findNews(Long id);
}
