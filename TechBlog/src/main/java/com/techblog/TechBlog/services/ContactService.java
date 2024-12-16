package com.techblog.TechBlog.services;

import com.techblog.TechBlog.dtos.contact.ContactDashboardDto;
import com.techblog.TechBlog.dtos.contact.ContactSendDto;

import java.util.List;

public interface ContactService {
    void sendEmail(ContactSendDto contactSendDto);

    List<ContactDashboardDto> getAllContacts();
}
