package com.techblog.TechBlog.services;


import com.techblog.TechBlog.dtos.author.AuthorDetailsDto;
import com.techblog.TechBlog.dtos.author.AuthorDto;
import com.techblog.TechBlog.model.Author;

import java.util.List;

public interface AuthorService {
    AuthorDetailsDto getAuthorDetails(Long id);

    List<AuthorDto> getDashboardAuthors();

    void deleteAuthor(Long id);
}
