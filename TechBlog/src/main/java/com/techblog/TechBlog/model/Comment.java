package com.techblog.TechBlog.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private boolean approved;

    @ManyToOne
    private News news;

    @ManyToOne
    private User user;
}
