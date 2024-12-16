package com.techblog.TechBlog.services;

import com.techblog.TechBlog.dtos.comment.CommentCreateDto;
import com.techblog.TechBlog.dtos.comment.CommentListDto;

import java.util.List;

public interface CommentService {
    void createComment(CommentCreateDto commentCreateDto);

    List<CommentListDto> getNewsComments(Long id);
}
