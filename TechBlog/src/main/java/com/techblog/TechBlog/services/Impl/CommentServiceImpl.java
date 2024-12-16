package com.techblog.TechBlog.services.Impl;

import com.techblog.TechBlog.dtos.comment.CommentCreateDto;
import com.techblog.TechBlog.dtos.comment.CommentListDto;
import com.techblog.TechBlog.model.Comment;
import com.techblog.TechBlog.model.News;
import com.techblog.TechBlog.model.User;
import com.techblog.TechBlog.repositories.CommentRepository;
import com.techblog.TechBlog.services.CommentService;
import com.techblog.TechBlog.services.NewsService;
import com.techblog.TechBlog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final NewsService newsService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    @Override
    public void createComment(CommentCreateDto commentCreateDto) {
        User user = userService.findUser(commentCreateDto.getUserEmail());
        News news = newsService.findNews(commentCreateDto.getNewsId());
        Comment comment = new Comment();
        comment.setContent(commentCreateDto.getContent());
        comment.setUser(user);
        comment.setNews(news);
        comment.setApproved(false);
        commentRepository.save(comment);

    }

    @Override
    public List<CommentListDto> getNewsComments(Long id) {
        List<Comment> commentList = commentRepository.findByNewsId(id);
        return commentList.stream().map(comment -> modelMapper.map(comment,CommentListDto.class)).toList();
    }
}
