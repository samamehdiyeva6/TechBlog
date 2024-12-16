package com.techblog.TechBlog.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    @Column(length=200)
    private String info;

    @OneToMany(mappedBy = "author")
    private List<News> news;

    @OneToMany(mappedBy = "author")
    private List<Video> videos;
}
