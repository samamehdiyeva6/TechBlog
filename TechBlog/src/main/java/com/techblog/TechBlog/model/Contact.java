package com.techblog.TechBlog.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String number;
    private String subject;
    private String message;
}
