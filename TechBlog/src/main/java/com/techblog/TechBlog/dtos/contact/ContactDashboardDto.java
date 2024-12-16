package com.techblog.TechBlog.dtos.contact;

import lombok.Data;

@Data
public class ContactDashboardDto {
    private Long id;
    private String name;
    private String email;
    private String number;
    private String subject;
    private String message;
}
