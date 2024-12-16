package com.techblog.TechBlog.services.Impl;

import com.techblog.TechBlog.dtos.news.NewsDashboardDto;
import com.techblog.TechBlog.dtos.news.NewsDetailsDto;
import com.techblog.TechBlog.dtos.news.PopularNewsDto;
import com.techblog.TechBlog.model.News;
import com.techblog.TechBlog.repositories.AuthorRepository;
import com.techblog.TechBlog.repositories.CategoryRepository;
import com.techblog.TechBlog.repositories.NewsRepository;
import com.techblog.TechBlog.services.NewsService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    @Override
    public Page<News> getAllNews(Integer pageNumber) {
        pageNumber = pageNumber==null? 0 : pageNumber-1;
        Pageable pageable = PageRequest.of(pageNumber,10,Sort.by("id").descending());
        Page<News> news = newsRepository.findAll(pageable);
        return news;
    }

    @Override
    public NewsDetailsDto getNews(Long id) {
        News news = newsRepository.findById(id).orElseThrow();
        NewsDetailsDto newsDetailsDto = modelMapper.map(news, NewsDetailsDto.class);
        return newsDetailsDto;
    }

    @Override
    public News getFirstNews() {
        List<News> news = newsRepository.getFirstNews();
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public List<News> getTwoNews() {
        List<News> news = newsRepository.getTwoNews();
        return news.isEmpty() ? null : news;
    }


    @Override
    public List<NewsDetailsDto> getAuthorNews(Long id) {
        List<News> news = newsRepository.getAuthorNews(id);
        List<NewsDetailsDto> newsDetailsDto = news.stream().map(n ->modelMapper.map(n,NewsDetailsDto.class)).toList();
        return newsDetailsDto;
    }

    @Override
    public List<PopularNewsDto> getPopularNews() {
        List<News> news = newsRepository.getPopularNews();
        List<PopularNewsDto> popularNews = news.stream().map(popular ->modelMapper.map(popular,PopularNewsDto.class)).toList();
        return popularNews;
    }

    @Override
    public List<NewsDetailsDto> getCategoryNews(Long id) {
        List<News> news = newsRepository.getCategoryNews(id);
        List<NewsDetailsDto> categoryNews = news.stream().map(n ->modelMapper.map(n,NewsDetailsDto.class)).toList();
        return categoryNews;
    }


//    CRUD

    @Override
    public void deleteNews(Long id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("News with ID " + id + " not found");
        }
    }


    @Override
    public List<NewsDashboardDto> allNews() {
        List<News> news = newsRepository.findAllByOrderByIdASC();
        List<NewsDashboardDto> newsDashboardDto = news.stream().map(n -> modelMapper.map(n,NewsDashboardDto.class)).toList();
        return newsDashboardDto;
    }

    @Override
    public News findNews(Long id) {
        News news = newsRepository.findById(id).orElseThrow();
        return news;
    }


}
