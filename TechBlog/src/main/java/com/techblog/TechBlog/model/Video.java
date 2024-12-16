package com.techblog.TechBlog.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 10000)
    private String content;
    @ManyToOne
    private Author author;
    private String videoUrl;
    private Long views;
}
