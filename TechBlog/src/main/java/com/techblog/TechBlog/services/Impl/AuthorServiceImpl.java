package com.techblog.TechBlog.services.Impl;

import com.techblog.TechBlog.dtos.author.AuthorDetailsDto;
import com.techblog.TechBlog.dtos.author.AuthorDto;
import com.techblog.TechBlog.model.Author;
import com.techblog.TechBlog.repositories.AuthorRepository;
import com.techblog.TechBlog.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Override
    public AuthorDetailsDto getAuthorDetails(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        AuthorDetailsDto authorDetailsDto = modelMapper.map(author, AuthorDetailsDto.class);
        return authorDetailsDto;
    }


    //    CRUD

    @Override
    public List<AuthorDto> getDashboardAuthors() {
        List<Author> authors = authorRepository.findAllByOrderByIdASC();
        return authors.stream().map(a ->modelMapper.map(a,AuthorDto.class)).toList();
    }


    @Override
    public void deleteAuthor(Long id) {
        if(authorRepository.existsById(id)){
            authorRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("News with ID " + id + " not found");
        }
    }


}
