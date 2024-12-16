package com.techblog.TechBlog.dtos.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDetailsDto {
    private Long id;
    private String author;
    private String info;
}
