package com.techblog.TechBlog.dtos.comment;

import com.techblog.TechBlog.dtos.user.UserCommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentListDto {
    private UserCommentDto user;
    private String content;
}
