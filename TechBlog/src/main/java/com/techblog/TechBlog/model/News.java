package com.techblog.TechBlog.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String editor1; // Short description
    @Column(length = 30000)
    private String editor2;
    private String photoUrl;
    private Long views;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "news")
    List<Comment> comments = new ArrayList<>();
}
